package africa.todo.data.repositories;

import africa.todo.data.models.Reminder;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ReminderRepository extends MongoRepository<Reminder, String> {
    Optional<Reminder> findById(String id);
//    Optional<Reminder> findReminderByNameOfTask(String nameOfTask);
//    Optional<Reminder> findReminderByReminderTime(String reminderTime);
}
