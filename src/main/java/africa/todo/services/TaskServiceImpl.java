package africa.todo.services;

import africa.todo.data.models.Status;
import africa.todo.data.models.Task;
import africa.todo.data.models.User;
import africa.todo.data.repositories.TaskRepository;
import africa.todo.dataTransferObjects.requests.CreateTaskRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskServices{
    @Autowired
    private TaskRepository taskRepository;
    @Override
    public void createTask(CreateTaskRequest createTaskRequest) {
        Task task = new Task();
        task.setTaskName(createTaskRequest.getTaskName());
        task.setContent(createTaskRequest.getContent());
        task.setTaskDateTime();

    }
}
