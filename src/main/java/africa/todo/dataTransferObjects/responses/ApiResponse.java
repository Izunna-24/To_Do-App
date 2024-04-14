package africa.todo.dataTransferObjects.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatusCode;

@Data
@AllArgsConstructor
public class ApiResponse {
    private boolean is_Ok;
    private Object data;
}
