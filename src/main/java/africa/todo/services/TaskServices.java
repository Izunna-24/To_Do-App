package africa.todo.services;

import africa.todo.dataTransferObjects.requests.CreateTaskRequest;

public interface TaskServices {
    void createTask(CreateTaskRequest createTaskRequest);
}
