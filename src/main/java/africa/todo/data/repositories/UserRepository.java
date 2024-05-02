package africa.todo.data.repositories;

import africa.todo.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
User findByUsername(String username);

    boolean existsByUsername(String username);
}
