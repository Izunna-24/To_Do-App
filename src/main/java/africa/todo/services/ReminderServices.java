package africa.todo.services;

import africa.todo.data.models.Reminder;
import africa.todo.dataTransferObjects.requests.SetReminderRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public interface ReminderServices {
    Reminder setReminder(SetReminderRequest setReminderRequest);
}
