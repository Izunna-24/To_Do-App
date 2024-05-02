package africa.todo.dataTransferObjects.responses;

import lombok.Data;

@Data
public class LoginResponse {
private String username;
private boolean isLocked;
}
