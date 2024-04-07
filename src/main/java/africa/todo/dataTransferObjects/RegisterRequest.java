package africa.todo.dataTransferObjects;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
}
