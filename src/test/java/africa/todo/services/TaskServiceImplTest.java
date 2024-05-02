//package africa.todo.services;
//
//import africa.todo.data.models.Category;
//import africa.todo.data.models.Priority;
//import africa.todo.data.models.Status;
//import africa.todo.data.repositories.TaskRepository;
//import africa.todo.dataTransferObjects.requests.CreateTaskRequest;
//import africa.todo.dataTransferObjects.requests.DeleteTaskRequest;
//import africa.todo.dataTransferObjects.requests.EditTaskRequest;
//import africa.todo.dataTransferObjects.requests.ViewAllTaskRequest;
//import africa.todo.dataTransferObjects.responses.ViewAllTaskResponse;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.LocalDateTime;
//
//import static org.junit.jupiter.api.Assertions.*;
//@SpringBootTest
//class TaskServiceImplTest {
//    @Autowired
//    private TaskServices taskServices;
//    @Autowired
//    private TaskRepository taskRepository;
//
//    @BeforeEach
//    public void defaultState(){
//        taskRepository.deleteAll();
//    }
//
//    @Test
//    public void taskCanBeCreated_andSavedInRepoTest(){
//        CreateTaskRequest createTaskRequest = new CreateTaskRequest();
//        createTaskRequest.setTaskName("Call Tayo");
//
//        LocalDateTime taskDateTime = LocalDateTime.of(2024,8, 4, 12,0);
//        createTaskRequest.setTaskDateTime(taskDateTime);
//
//        createTaskRequest.setCategory(Category.PERSONAL);
//        createTaskRequest.setContent("Call Tayo to inform her I'm breaking up");
//        createTaskRequest.setPriority(Priority.LOW);
//        createTaskRequest.setStatus(Status.PENDING);
//
//        taskServices.createTask(createTaskRequest);
//        assertEquals(1,taskRepository.count());
//
//    }
//
//    @Test
//    public void twoTasksAreCreated_andNumberOfTaskIncreasesByOneTest(){
//        CreateTaskRequest createTaskRequest = new CreateTaskRequest();
//        createTaskRequest.setTaskName("Call Tayo");
//
//        LocalDateTime taskDateTime = LocalDateTime.of(2024,8, 4, 12,0);
//        createTaskRequest.setTaskDateTime(taskDateTime);
//
//        createTaskRequest.setCategory(Category.PERSONAL);
//        createTaskRequest.setContent("Call Tayo to inform her I'm breaking up");
//        createTaskRequest.setPriority(Priority.LOW);
//        createTaskRequest.setStatus(Status.PENDING);
//
//        taskServices.createTask(createTaskRequest);
//
//        CreateTaskRequest taskTwo = new CreateTaskRequest();
//        taskTwo.setTaskName("Swimming");
//
//        LocalDateTime taskTwoDateTime = LocalDateTime.of(2024,4, 19, 19,0);
//        taskTwo.setTaskDateTime(taskTwoDateTime);
//
//        taskTwo.setCategory(Category.PERSONAL);
//        taskTwo.setContent("Should go swimming as recommended");
//        taskTwo.setPriority(Priority.HIGH);
//        taskTwo.setStatus(Status.PENDING);
//
//        taskServices.createTask(taskTwo);
//
//        assertEquals(2,taskRepository.count());
//
//    }
//
//    @Test
//    public void differentTaskCanBeCreated_onSameDateTest(){
//        CreateTaskRequest createTaskRequest = new CreateTaskRequest();
//        createTaskRequest.setTaskName("Study for Mock");
//
//        LocalDateTime taskDateTime = LocalDateTime.of(2024,8, 4, 12,0);
//        createTaskRequest.setTaskDateTime(taskDateTime);
//
//        createTaskRequest.setCategory(Category.PERSONAL);
//        createTaskRequest.setContent("studying second chapter of my text for my Mock");
//        createTaskRequest.setPriority(Priority.HIGH);
//        createTaskRequest.setStatus(Status.PENDING);
//
//        taskServices.createTask(createTaskRequest);
//        assertEquals(1,taskRepository.count());
//
//    }
//
//    @Test
//    public void createdTask_canBeViewedTest(){
//        CreateTaskRequest createTaskRequest = new CreateTaskRequest();
//        createTaskRequest.setTaskName("Study for Mock");
//
//        LocalDateTime taskDateTime = LocalDateTime.of(2024,8, 4, 12,0);
//        createTaskRequest.setTaskDateTime(taskDateTime);
//
//        createTaskRequest.setCategory(Category.PERSONAL);
//        createTaskRequest.setContent("studying second chapter of my text for my Mock");
//        createTaskRequest.setPriority(Priority.HIGH);
//        createTaskRequest.setStatus(Status.PENDING);
//
//        taskServices.createTask(createTaskRequest);
//
//        assertEquals(1,taskRepository.count());
//
//        ViewAllTaskRequest viewAllTaskRequest = new ViewAllTaskRequest();
//        viewAllTaskRequest.setId(taskRepository.findAll().getFirst().getId());
//        viewAllTaskRequest.setTaskName("Study for Mock");
//        ViewAllTaskResponse viewAllTaskResponse = taskServices.viewAllTask(viewAllTaskRequest);
//
//        assertEquals("Study for Mock", viewAllTaskResponse.getTask().getTaskName());
//
//
//
//    }
//
//    @Test
//    public void twoTasksAreCreated_oneIsDeletedOneRemainsTest(){
//        CreateTaskRequest createTaskRequest = new CreateTaskRequest();
//        createTaskRequest.setTaskName("Call Tayo");
//
//        LocalDateTime taskDateTime = LocalDateTime.of(2024,8, 4, 12,0);
//        createTaskRequest.setTaskDateTime(taskDateTime);
//
//        createTaskRequest.setCategory(Category.PERSONAL);
//        createTaskRequest.setContent("Call Tayo to inform her I'm breaking up");
//        createTaskRequest.setPriority(Priority.LOW);
//        createTaskRequest.setStatus(Status.PENDING);
//
//        taskServices.createTask(createTaskRequest);
//
//        CreateTaskRequest taskTwo = new CreateTaskRequest();
//        taskTwo.setTaskName("Swimming");
//
//        LocalDateTime taskTwoDateTime = LocalDateTime.of(2024,4, 19, 19,0);
//        taskTwo.setTaskDateTime(taskTwoDateTime);
//
//        taskTwo.setCategory(Category.PERSONAL);
//        taskTwo.setContent("Should go swimming as recommended");
//        taskTwo.setPriority(Priority.HIGH);
//        taskTwo.setStatus(Status.PENDING);
//        taskServices.createTask(taskTwo);
//
//        DeleteTaskRequest deleteTaskRequest = new DeleteTaskRequest();
//        deleteTaskRequest.setId(taskRepository.findAll().getFirst().getId());
//        taskServices.deleteTask(deleteTaskRequest);
//        assertEquals(1,taskRepository.count());
//
//    }
//    @Test
//    public void taskCanBeCreated_andCreatedTaskCanBeEditedTest(){
//        CreateTaskRequest createTaskRequest = new CreateTaskRequest();
//        createTaskRequest.setTaskName("Call Tayo");
//
//        LocalDateTime taskDateTime = LocalDateTime.of(2024,8, 4, 12,0);
//        createTaskRequest.seTaskDateTime(taskDateTime);
//
//        createTaskRequest.setCategory(Category.PERSONAL);
//        createTaskRequest.setContent("Call Tayo to inform her I'm breaking up");
//        createTaskRequest.setPriority(Priority.LOW);
//        createTaskRequest.setStatus(Status.PENDING);
//
//        taskServices.createTask(createTaskRequest);
//        assertEquals(1,taskRepository.count());
//        EditTaskRequest editTaskRequest = new EditTaskRequest();
//
//    }
//
//
//}