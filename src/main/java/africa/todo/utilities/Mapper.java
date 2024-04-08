package africa.todo.utilities;

import africa.todo.data.models.User;
import africa.todo.dataTransferObjects.requests.RegisterRequest;
import africa.todo.dataTransferObjects.responses.RegisterResponse;

public class Mapper {
    public static User regMap(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        return user;
    }

    public static RegisterResponse regResponseMap(User user) {
        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setUserId(user.getId());
        registerResponse.setUsername(user.getUsername());
        return registerResponse;
    }
}
