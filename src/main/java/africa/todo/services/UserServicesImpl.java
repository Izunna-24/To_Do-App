package africa.todo.services;

import africa.todo.data.models.Task;
import africa.todo.data.models.User;
import africa.todo.data.repositories.UserRepository;
import africa.todo.dataTransferObjects.requests.CreateTaskRequest;
import africa.todo.dataTransferObjects.requests.DeleteTaskRequest;
import africa.todo.dataTransferObjects.requests.EditTaskRequest;
import africa.todo.dataTransferObjects.requests.RegisterRequest;
import africa.todo.dataTransferObjects.responses.CreateTaskResponse;
import africa.todo.dataTransferObjects.responses.DeleteTaskResponse;
import africa.todo.dataTransferObjects.responses.EditTaskResponse;
import africa.todo.dataTransferObjects.responses.RegisterResponse;
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
        Optional<User> user = userRepository.findById(createTaskRequest.getId());
        Task task = taskServices.createTask(createTaskRequest);
        userRepository.save(user);
    }



    @Override
    public EditTaskResponse editTask(EditTaskRequest editTaskRequest) {
        return null;
    }

    @Override
    public DeleteTaskResponse deleteTask(DeleteTaskRequest deleteTaskRequest) {
        return null;
    }

    @Override
    public List<Task> findTaskByName(String taskName) {
        return null;
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
