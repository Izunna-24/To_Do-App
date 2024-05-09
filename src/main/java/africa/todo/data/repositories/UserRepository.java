package africa.todo.data.repositories;

import africa.todo.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends MongoRepository<User, String> {
User findByUsername(String username);
boolean existsByUsernameIgnoreCase(String username);

}
