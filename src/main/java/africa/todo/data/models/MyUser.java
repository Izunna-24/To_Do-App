package africa.todo.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Data
@Document("Users")
public class MyUser {
    //private String name;
    private String username;
    @Id
    private String id;
    @DBRef
    private List<Task> tasks = new ArrayList<>();
    @DBRef
    private List<Reminder> reminders = new ArrayList<>();
}
