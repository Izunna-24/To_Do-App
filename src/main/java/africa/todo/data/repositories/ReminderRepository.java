package africa.todo.data.repositories;

import africa.todo.data.models.Reminder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
@Repository
public interface ReminderRepository extends MongoRepository<Reminder, String> {
    //Reminder  findById (String id);
   Optional<Reminder> findReminderByNameOfTask(String nameOfTask);
   Optional<Reminder> findReminderByReminderTime(String reminderTime);
}
