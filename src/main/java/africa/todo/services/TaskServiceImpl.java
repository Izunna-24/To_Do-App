package africa.todo.services;

import africa.todo.data.models.Task;
import africa.todo.data.repositories.TaskRepository;
import africa.todo.dataTransferObjects.requests.CreateTaskRequest;
import africa.todo.dataTransferObjects.requests.DeleteTaskRequest;
import africa.todo.dataTransferObjects.requests.EditTaskRequest;
import africa.todo.dataTransferObjects.requests.ViewTaskRequest;
import africa.todo.exceptions.TaskContentEmptyException;
import africa.todo.exceptions.TaskNameEmptyException;
import africa.todo.exceptions.TaskNotFoundException;
import africa.todo.utilities.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskServices{
    @Autowired
    private TaskRepository taskRepository;
    @Override
    public Task createTask(CreateTaskRequest createTaskRequest) {
        validateTaskCreation(createTaskRequest);
        Task task = Mapper.createTaskMap(createTaskRequest);
        taskRepository.save(task);
        return Mapper.taskCreatedResponse(task);
    }

    private static void validateTaskCreation(CreateTaskRequest createTaskRequest) {
        if(createTaskRequest.getTaskName() == null || createTaskRequest.getTaskName().isEmpty()) throw new TaskNameEmptyException("Name of Task field is not filled");
        if (createTaskRequest.getContent() == null || createTaskRequest.getContent().isEmpty()) throw new TaskContentEmptyException("Task content field must be filled");
    }

    @Override
    public Task viewTask(ViewTaskRequest viewTaskRequest) {
        //Task task = new Task();
        Optional<Task> task = taskRepository.findByTaskId(viewTaskRequest.getId());
        if (!taskRepository.existsById(viewTaskRequest.getId()))
            throw new TaskNotFoundException("Task was never created");
        return task.get();
    }

    @Override
    public Task deleteTask(DeleteTaskRequest deleteTaskRequest) {
        Task task = findById(deleteTaskRequest.getId());
        taskRepository.delete(task);
        return task;
    }

    @Override
    public Task editTask(EditTaskRequest editTaskRequest) {
        Task task = findById(editTaskRequest.getId());
        if (editTaskRequest.getTaskName() == null || editTaskRequest.getTaskName().isEmpty())
            throw new TaskNameEmptyException("This field must not be empty");
        task.setTaskName(editTaskRequest.getTaskName());
        task.setContent(editTaskRequest.getContent());
        task.setCategory(editTaskRequest.getCategory());
        task.setPriority(editTaskRequest.getPriority());
        task.setTaskDateTime(LocalDateTime.now());
        return taskRepository.save(task);
    }

//    @Override
//    public Task findTaskByUser(User user) {
//        Optional<Task> task = taskRepository.findBy();
//        if (task.isEmpty()) throw new TaskNotFoundException("Task was never created!");
//        return task.get();
//    }



    @Override
    public List<Task> findAllTask() {
        return taskRepository.findAll();
    }

    @Override
    public Task findTaskByTitle(String title) {
        return null;
    }

    @Override
    public Task findById(String id) {
    Optional<Task> task = taskRepository.findByTaskId(id);
    if (task.isEmpty()) throw new TaskNotFoundException("Task was never created!");
    return task.get();
    }


}
