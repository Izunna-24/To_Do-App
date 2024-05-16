package africa.todo.services;

import africa.todo.data.models.Task;
import africa.todo.data.models.User;
import africa.todo.data.repositories.TaskRepository;
import africa.todo.data.repositories.UserRepository;
import africa.todo.dataTransferObjects.requests.*;
import africa.todo.dataTransferObjects.responses.*;
import africa.todo.exceptions.TaskContentEmptyException;
import africa.todo.exceptions.TaskNameEmptyException;
import africa.todo.exceptions.TaskNotFoundException;
import africa.todo.exceptions.UserNotFoundException;
import africa.todo.utilities.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskServices {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public CreateTaskResponse createTask(CreateTaskRequest createTaskRequest) {
        validateTaskCreation(createTaskRequest);
        Task task = Mapper.createTaskMap(createTaskRequest);
        taskRepository.save(task);
        return Mapper.createTaskResponse(task);
    }

    private static void validateTaskCreation(CreateTaskRequest createTaskRequest) {
        if (createTaskRequest.getTaskName() == null || createTaskRequest.getTaskName().isEmpty())
            throw new TaskNameEmptyException("Name of task field must be filled");
        if (createTaskRequest.getContent() == null || createTaskRequest.getContent().isEmpty())
            throw new TaskContentEmptyException("Task content field must be filled");
    }

    @Override
    public ViewAllTaskResponse viewAllTask(ViewAllTaskRequest viewAllTaskRequest) {
        Optional<Task> task = taskRepository.findById(viewAllTaskRequest.getId());
        if (task.isEmpty())
            throw new TaskNotFoundException("Task was never created");
        return Mapper.viewTaskResponse(task.get());
    }

    @Override
    public Task findTaskById(String id) {
        Task task = taskRepository.findByTaskId(id);
        if (task == null) throw new TaskNotFoundException("Task was never created!");
        return task;
    }







    @Override
    public DeleteTaskResponse deleteTask(DeleteTaskRequest deleteTaskRequest) {
        Task task = findTaskById(deleteTaskRequest.getTaskId());
        taskRepository.delete(task);
        return Mapper.deleteTaskResponse(task);
    }



    @Override
    public EditTaskResponse editTask(EditTaskRequest editTaskRequest) {
        if (editTaskRequest.getTaskName() == null || editTaskRequest.getTaskName().isEmpty())
            throw new TaskNameEmptyException("This field must not be empty");
        Task task = findTaskById(editTaskRequest.getTaskId());
        Task editedTask = Mapper.editTaskMap(editTaskRequest, task);
        taskRepository.save(editedTask);
        return Mapper.editTaskResponse(editedTask);
    }
    @Override
    public List<Task> findAllTask() {
        return taskRepository.findAll();
    }

    @Override
    public Task findByName(String taskTitle) {
        Task task = taskRepository.findByTaskName(taskTitle);
        if (task == null) throw new TaskNameEmptyException("No Task found with this name");
        return task;
    }




}
