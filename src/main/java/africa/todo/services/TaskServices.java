package africa.todo.services;

import africa.todo.dataTransferObjects.requests.CreateTaskRequest;
import africa.todo.dataTransferObjects.requests.ViewTaskRequest;

public interface TaskServices {
    void createTask(CreateTaskRequest createTaskRequest);
    void viewTask(ViewTaskRequest viewTaskRequest);
}
