package africa.todo.services;

import africa.todo.data.models.Category;
import africa.todo.data.models.Priority;
import africa.todo.data.repositories.TaskRepository;
import africa.todo.dataTransferObjects.requests.CreateTaskRequest;
import africa.todo.dataTransferObjects.requests.DeleteTaskRequest;
import africa.todo.dataTransferObjects.requests.EditTaskRequest;
import africa.todo.dataTransferObjects.requests.ViewAllTaskRequest;
import africa.todo.dataTransferObjects.responses.CreateTaskResponse;
import africa.todo.dataTransferObjects.responses.EditTaskResponse;
import africa.todo.dataTransferObjects.responses.ViewAllTaskResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TaskServiceImplTest {
    @Autowired
    private TaskServices taskServices;
    @Autowired
    private TaskRepository taskRepository;

    @BeforeEach
    public void defaultState(){
        taskRepository.deleteAll();
    }

    @Test
    public void taskCanBeCreated_andSavedInRepoTest(){
        CreateTaskRequest createTaskRequest = new CreateTaskRequest();
        createTaskRequest.setTaskName("Call Tayo");

       String taskDateTime = "04/08/2024 12:00";
       createTaskRequest.setTaskDateTime(taskDateTime);
        createTaskRequest.setCategory(Category.PERSONAL);
        createTaskRequest.setContent("Call Tayo to inform her I'm breaking up");
        createTaskRequest.setPriority(Priority.LOW);
        createTaskRequest.setUserId("userId");

        taskServices.createTask(createTaskRequest);
        assertEquals(1,taskRepository.count());

    }

    @Test
    public void twoTasksAreCreated_andNumberOfTaskIncreasesByOneTest(){
        CreateTaskRequest createTaskRequest = new CreateTaskRequest();
        createTaskRequest.setTaskName("Call Tayo");

        String taskDateTime = "04/08/2024 12:00";
        createTaskRequest.setTaskDateTime(taskDateTime);
        createTaskRequest.setCategory(Category.PERSONAL);
        createTaskRequest.setContent("Call Tayo to inform her I'm breaking up");
        createTaskRequest.setPriority(Priority.LOW);
        createTaskRequest.setUserId("userId");


        taskServices.createTask(createTaskRequest);

        CreateTaskRequest taskTwo = new CreateTaskRequest();
        taskTwo.setTaskName("Call Tayo");

        String taskDateTime2 = "04/08/2024 12:00";
        taskTwo.setTaskDateTime(taskDateTime2);
        taskTwo.setCategory(Category.PERSONAL);
        taskTwo.setContent("Call Tayo to inform her I'm breaking up");
        taskTwo.setPriority(Priority.LOW);
        taskTwo.setUserId("userId");


        taskServices.createTask(taskTwo);

        assertEquals(2,taskRepository.count());

    }
    @Test
    public void createdTask_canBeViewedTest(){
        CreateTaskRequest createTaskRequest = new CreateTaskRequest();
        createTaskRequest.setTaskName("Call Tayo");

        String taskDateTime = "04/08/2024 12:00";
        createTaskRequest.setTaskDateTime(taskDateTime);
        createTaskRequest.setCategory(Category.PERSONAL);
        createTaskRequest.setContent("Call Tayo to inform her I'm breaking up");
        createTaskRequest.setPriority(Priority.LOW);
        createTaskRequest.setUserId("userId");


        taskServices.createTask(createTaskRequest);

        assertEquals(1,taskRepository.count());

        ViewAllTaskRequest viewAllTaskRequest = new ViewAllTaskRequest();
        viewAllTaskRequest.setId(taskRepository.findAll().getFirst().getTaskId());
        viewAllTaskRequest.setTaskName("Call Tayo");
        ViewAllTaskResponse viewAllTaskResponse = taskServices.viewAllTask(viewAllTaskRequest);

        assertEquals("Call Tayo", viewAllTaskResponse.getTask().getTaskName());



    }

    @Test
    public void twoTasksAreCreated_oneIsDeletedOneRemainsTest(){
        CreateTaskRequest createTaskRequest = new CreateTaskRequest();
        createTaskRequest.setTaskName("Call Tayo");

        String taskDateTime = "04/09/2027 01:20";
        createTaskRequest.setTaskDateTime(taskDateTime);
        createTaskRequest.setCategory(Category.PERSONAL);
        createTaskRequest.setContent("Call Tayo to inform her I'm breaking up");
        createTaskRequest.setPriority(Priority.LOW);
        createTaskRequest.setUserId("userid");

        taskServices.createTask(createTaskRequest);

        CreateTaskRequest taskTwo = new CreateTaskRequest();
        taskTwo.setTaskName("Swimming");
        taskTwo.setTaskDateTime("09/04/2024 13:29");

        taskTwo.setCategory(Category.PERSONAL);
        taskTwo.setContent("Should go swimming as recommended");
        taskTwo.setPriority(Priority.HIGH);
        taskTwo.setUserId("userid");
        taskServices.createTask(taskTwo);

        DeleteTaskRequest deleteTaskRequest = new DeleteTaskRequest();
        deleteTaskRequest.setTaskId(taskRepository.findAll().getFirst().getTaskId());
        taskServices.deleteTask(deleteTaskRequest);
        assertEquals(1,taskRepository.count());

    }

    @Test
    public void twoTasksAreCreated_secondOneIsDeletedFirstOneStillThereTest(){
        CreateTaskRequest createTaskRequest = new CreateTaskRequest();
        createTaskRequest.setTaskName("Call Tayo");

        String taskDateTime = "04/09/2027 01:20";
        createTaskRequest.setTaskDateTime(taskDateTime);
        createTaskRequest.setCategory(Category.PERSONAL);
        createTaskRequest.setContent("Call Tayo to inform her I'm breaking up");
        createTaskRequest.setPriority(Priority.LOW);
        createTaskRequest.setUserId("userId");

        taskServices.createTask(createTaskRequest);

        CreateTaskRequest taskTwo = new CreateTaskRequest();
        taskTwo.setTaskName("Swimming");
        taskTwo.setTaskDateTime("09/04/2024 13:29");

        taskTwo.setCategory(Category.PERSONAL);
        taskTwo.setContent("Should go swimming as recommended");
        taskTwo.setPriority(Priority.HIGH);
        taskTwo.setUserId("userId");
        taskServices.createTask(taskTwo);

        DeleteTaskRequest deleteTaskRequest = new DeleteTaskRequest();
        deleteTaskRequest.setTaskId(taskRepository.findAll().get(1).getTaskId());
        taskServices.deleteTask(deleteTaskRequest);
        assertEquals(1,taskRepository.count());

    }
    @Test
    public void taskCanBeEditedTest(){
        CreateTaskRequest createTaskRequest = new CreateTaskRequest();
        createTaskRequest.setTaskName("Call Tayo");

       createTaskRequest.setTaskDateTime("10/10/2028 10:00");

        createTaskRequest.setCategory(Category.PERSONAL);
        createTaskRequest.setContent("Call Tayo to inform her I'm breaking up");
        createTaskRequest.setPriority(Priority.LOW);
        createTaskRequest.setUserId("userId");
        CreateTaskResponse createdTask = taskServices.createTask(createTaskRequest);
        String taskId = createdTask.getTaskId();
        assertEquals(1,taskRepository.count());

        EditTaskRequest editTaskRequest = new EditTaskRequest();
        editTaskRequest.setTaskName("HolyGround");
        editTaskRequest.setTaskDateTime("09/11/2024 12:24");
        editTaskRequest.setTaskId(taskId);

        editTaskRequest.setContent("Tame the beast");
        editTaskRequest.setUserId("userId");
        editTaskRequest.setPriority(Priority.HIGH);
        editTaskRequest.setCategory(Category.WORK);

        EditTaskResponse editedTask = taskServices.editTask(editTaskRequest);

        assertNotNull(editedTask);

//        System.out.println("Original Task:");
//        System.out.println(createdTask.toString());
//        System.out.println("Edited Task:");
//        System.out.println(editedTask.toString());

        assertEquals(taskId, editedTask.getTaskId());


    }



}