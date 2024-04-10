package africa.todo.services;

import africa.todo.data.models.Status;
import africa.todo.data.models.Task;
import africa.todo.data.models.User;
import africa.todo.data.repositories.TaskRepository;
import africa.todo.dataTransferObjects.requests.CreateTaskRequest;
import africa.todo.dataTransferObjects.requests.ViewTaskRequest;
import africa.todo.exceptions.TaskNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskServices{
    @Autowired
    private TaskRepository taskRepository;
    @Override
    public void createTask(CreateTaskRequest createTaskRequest) {
        Task task = new Task();
        task.setTaskName(createTaskRequest.getTaskName());
        task.setContent(createTaskRequest.getContent());
        task.setTaskDateTime(LocalDateTime.now());
        taskRepository.save(task);

    }

    @Override
    public void viewTask(ViewTaskRequest viewTaskRequest) {
        Optional<Task> task = taskRepository.findByTaskId(viewTaskRequest.getId());
        if (!taskRepository.existsById(viewTaskRequest.getId())) throw new TaskNotFoundException("Task was never created");
    }


}
