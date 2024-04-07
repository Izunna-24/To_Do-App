package africa.todo.data.repositories;

import africa.todo.data.models.MyUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MyUserRepository extends MongoRepository<MyUser, String> {
    Optional<MyUser> findById(String id);
}
