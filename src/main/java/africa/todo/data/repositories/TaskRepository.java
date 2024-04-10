package africa.todo.data.repositories;

import africa.todo.data.models.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TaskRepository extends MongoRepository<Task,String> {
Optional<Task> findByTaskId(String id);
Optional<Task> findByTaskName(String taskName);
}
