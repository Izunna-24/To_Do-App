package africa.todo.services;

import africa.todo.data.models.Task;
import africa.todo.data.models.User;
import africa.todo.data.repositories.UserRepository;
import africa.todo.dataTransferObjects.requests.*;
import africa.todo.dataTransferObjects.responses.*;
import africa.todo.exceptions.TaskNotFoundException;
import africa.todo.exceptions.UserExistsException;
import africa.todo.utilities.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskServices taskServices;
    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        helpRegisterWith(registerRequest);
        registerRequest.setUsername(registerRequest.getUsername().toLowerCase());
        User user = Mapper.regMap(registerRequest);
        userRepository.save(user);
        return Mapper.regResponseMap(user);

    }

    @Override
    public CreateTaskResponse setTask(CreateTaskRequest createTaskRequest) {

        Optional<User> user = userRepository.findById(createTaskRequest.getUserId());

        Task task = taskServices.createTask(createTaskRequest);
        user.get().getTasks().add(task);
        userRepository.save(user.get());
        return Mapper.taskCreatedResponse(task);
    }



    @Override
    public EditTaskResponse editTask(EditTaskRequest editTaskRequest) {
        return taskServices.editTask(editTaskRequest);
    }

    @Override
    public DeleteTaskResponse deleteTask(DeleteTaskRequest deleteTaskRequest) {
        Optional<User> user = userRepository.findById(deleteTaskRequest.getUserId());
        Task task = findTask(deleteTaskRequest.getId(), user.get().getTasks());
        user.get().getTasks().remove(task);
        userRepository.save(user.get());
        return taskServices.deleteTask(deleteTaskRequest);
    }

    private Task findTask(String id, List<Task> tasks) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                return task;
            }
        }
        throw new TaskNotFoundException("Task not found");
    }

    @Override
    public List<Task> findTaskByName(String taskName) {
       // Task task =

        return null;
    }

    @Override
    public GetTaskResponse getTask(GetTaskRequest getTaskRequest) {
        Optional<User> user = userRepository.findById(getTaskRequest.getUserId());
        Task task = findTask(getTaskRequest.getTaskId(), user.get().getTasks());
        return Mapper.getTaskResponse(task);
    }

    private void helpRegisterWith(RegisterRequest registerRequest) {
        if (registerRequest == null) throw new NullPointerException("provide username and password");
        if (registerRequest.getUsername().contains(" ")) throw new IllegalArgumentException("Username should not contain space");
        if (registerRequest.getPassword().length() < 6) throw new IllegalArgumentException("password should be upto six character!");
        if (userRepository.existsByUsername(registerRequest.getUsername())){
            throw new UserExistsException(String.format("Account with username %s is already in use", registerRequest.getUsername()));
        }
    }




}
