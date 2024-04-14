package africa.todo.data.repositories;

import africa.todo.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
//    Optional<User> findById(String id);

    boolean existsByUsername(String username);
}
