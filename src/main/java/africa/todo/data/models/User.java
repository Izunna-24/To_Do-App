package africa.todo.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Data
@Document("Users")
public class User {
    //private String email;
    private String password;
    private String username;
    private String firstName;
    private String lastName;
    private boolean isLocked = true;
    @Id
    private String id;
    @DBRef
    private List<Task> tasks = new ArrayList<>();
    @DBRef
    private List<Reminder> reminders = new ArrayList<>();
}
