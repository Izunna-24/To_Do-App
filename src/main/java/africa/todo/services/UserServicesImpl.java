package africa.todo.services;

import africa.todo.data.models.User;
import africa.todo.data.repositories.UserRepository;
import africa.todo.dataTransferObjects.requests.RegisterRequest;
import africa.todo.dataTransferObjects.responses.RegisterResponse;
import africa.todo.exceptions.UserExistsException;
import africa.todo.utilities.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;
    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        helpRegisterWith(registerRequest);
        registerRequest.setUsername(registerRequest.getUsername().toLowerCase());
        User user = Mapper.regMap(registerRequest);
        userRepository.save(user);
        return Mapper.regResponseMap(user);

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
