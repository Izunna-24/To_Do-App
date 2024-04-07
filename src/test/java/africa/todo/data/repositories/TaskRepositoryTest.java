package africa.todo.data.repositories;

import africa.todo.data.models.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.junit.jupiter.api.Assertions.*;
@DataMongoTest
class TaskRepositoryTest {
    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void savingTaskInRepoTest(){
        taskRepository.deleteAll();
        Task task = new Task();
        taskRepository.save(task);
        assertEquals(1, taskRepository.count());
    }

}