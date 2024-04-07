package africa.todo.data.repositories;

import africa.todo.data.models.Reminder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;


import static org.junit.jupiter.api.Assertions.*;
@DataMongoTest
class ReminderRepositoryTest {
    @Autowired
    private ReminderRepository reminderRepository;

    @Test
    public  void savingRemindersTest(){
        reminderRepository.deleteAll();
        Reminder reminder = new Reminder();
        reminderRepository.save(reminder);
        assertEquals(1, reminderRepository.count());
    }

}