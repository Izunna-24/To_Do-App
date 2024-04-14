package africa.todo.services;

import africa.todo.data.models.Reminder;
import africa.todo.dataTransferObjects.requests.SetReminderRequest;

import java.time.LocalDateTime;

public interface ReminderServices {
    Reminder setReminder(SetReminderRequest setReminderRequest);
}
