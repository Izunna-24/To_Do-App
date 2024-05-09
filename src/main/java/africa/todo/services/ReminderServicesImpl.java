package africa.todo.services;

import africa.todo.data.models.Reminder;
import africa.todo.data.models.Task;
import africa.todo.data.repositories.ReminderRepository;
import africa.todo.dataTransferObjects.requests.SetReminderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReminderServicesImpl implements ReminderServices{
    @Autowired
    private TaskServices taskServices;
    @Autowired
    private ReminderRepository reminderRepository;
    @Override
    public Reminder setReminder(SetReminderRequest setReminderRequest) {
        Task task = taskServices.findTaskById(setReminderRequest.getTaskId());
        Reminder reminder = new Reminder();
        reminder.setReminderTime(setReminderRequest.getReminderTime());
        reminder.setNameOfTask(setReminderRequest.getNameOfTask());
        reminder.setPriority(setReminderRequest.getPriority());
        reminder.setReminderMessage(setReminderRequest.getMessage());
        return reminder;
    }
}
