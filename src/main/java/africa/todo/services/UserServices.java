package africa.todo.services;

import africa.todo.dataTransferObjects.requests.RegisterRequest;
import africa.todo.dataTransferObjects.responses.RegisterResponse;

public interface UserServices {
    RegisterResponse register(RegisterRequest registerRequest);

}
