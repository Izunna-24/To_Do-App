package africa.todo.data.repositories;

import africa.todo.data.models.Task;
import africa.todo.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface TaskRepository extends MongoRepository<Task,String> {
    Task findByTaskId(String taskId);

    Task findByTaskName(String taskTitle);
}
