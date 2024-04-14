package africa.todo.services;

import africa.todo.data.models.Task;
import africa.todo.dataTransferObjects.requests.CreateTaskRequest;
import africa.todo.dataTransferObjects.requests.DeleteTaskRequest;
import africa.todo.dataTransferObjects.requests.EditTaskRequest;
import africa.todo.dataTransferObjects.requests.ViewTaskRequest;

import java.util.List;

public interface TaskServices {
    Task createTask(CreateTaskRequest createTaskRequest);
    Task viewTask(ViewTaskRequest viewTaskRequest);
    Task deleteTask(DeleteTaskRequest deleteTaskRequest);
    Task editTask(EditTaskRequest editTaskRequest);
    //Task findTaskByUser(User user);
    List<Task> findAllTask();
    Task findTaskByTitle(String title);
    Task findById(String id);
}
