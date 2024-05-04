package africa.todo.services;

import africa.todo.data.models.Task;
import africa.todo.data.repositories.TaskRepository;
import africa.todo.dataTransferObjects.requests.CreateTaskRequest;
import africa.todo.dataTransferObjects.requests.DeleteTaskRequest;
import africa.todo.dataTransferObjects.requests.EditTaskRequest;
import africa.todo.dataTransferObjects.requests.ViewAllTaskRequest;
import africa.todo.dataTransferObjects.responses.CreateTaskResponse;
import africa.todo.dataTransferObjects.responses.DeleteTaskResponse;
import africa.todo.dataTransferObjects.responses.EditTaskResponse;
import africa.todo.dataTransferObjects.responses.ViewAllTaskResponse;
import africa.todo.exceptions.TaskContentEmptyException;
import africa.todo.exceptions.TaskNameEmptyException;
import africa.todo.exceptions.TaskNotFoundException;
import africa.todo.utilities.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskServices {
    @Autowired
    private TaskRepository taskRepository;

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
    public DeleteTaskResponse deleteTask(DeleteTaskRequest deleteTaskRequest) {
        Task task = findById(deleteTaskRequest.getId());
        taskRepository.delete(task);
        return Mapper.deleteTaskResponse(task);
    }

    @Override
    public EditTaskResponse editTask(EditTaskRequest editTaskRequest) {
        if (editTaskRequest.getTaskName() == null || editTaskRequest.getTaskName().isEmpty())
            throw new TaskNameEmptyException("This field must not be empty");
        Task task = findById(editTaskRequest.getId());
        Task editedTask = Mapper.editTaskMap(editTaskRequest, task);
        taskRepository.save(editedTask);
        return Mapper.editTaskResponse(editedTask);
    }
    @Override
    public List<Task> findAllTask() {
        return taskRepository.findAll();
    }

    @Override
    public Task findByName(String title) {
        Optional<Task> task = taskRepository.findByTaskName(title);
        if (task.isEmpty()) throw new TaskNameEmptyException("No Task found with this name");
        return task.get();
    }

    @Override
    public Task findById(String id) {
    Optional<Task> task = taskRepository.findById(id);
    if (task.isEmpty()) throw new TaskNotFoundException("Task was never created!");
    return task.get();
    }
//    @Override
//    public Task findTaskByUser(User user) {
//        Optional<Task> task = taskRepository.findBy();
//        if (task.isEmpty()) throw new TaskNotFoundException("Task was never created!");
//        return task.get();
//    }

}
