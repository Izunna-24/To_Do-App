package africa.todo.services;

import africa.todo.data.models.Category;
import africa.todo.data.models.Priority;
import africa.todo.data.models.Task;
import africa.todo.data.repositories.TaskRepository;
import africa.todo.data.repositories.UserRepository;
import africa.todo.dataTransferObjects.requests.AssignTaskRequest;
import africa.todo.dataTransferObjects.requests.CreateTaskRequest;
import africa.todo.dataTransferObjects.requests.LoginRequest;
import africa.todo.dataTransferObjects.requests.RegisterRequest;
import africa.todo.dataTransferObjects.responses.CreateTaskResponse;
import africa.todo.dataTransferObjects.responses.RegisterResponse;
import africa.todo.exceptions.ToDoExceptions;
import africa.todo.exceptions.UserExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServicesImplTest {
    @Autowired
    private UserServices userServices;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskServices taskServices;
    @Autowired
    private TaskRepository taskRepository;

    @BeforeEach
    public void routineClear(){
    userRepository.deleteAll();
}

    @Test
    public void userRegisters_numberOfUserIncreaseByOneTest(){
       RegisterRequest registerRequest = new RegisterRequest();
       registerRequest.setUsername("khlone");
       registerRequest.setPassword("password");
       userServices.register(registerRequest);
       assertEquals(1,userRepository.count());
   }

   @Test
    public void userRegisterWithSameDetailsTwice_repositoryThrowsUserExistException() {
       RegisterRequest registerRequest = new RegisterRequest();
       registerRequest.setFirstName("John");
       registerRequest.setLastName("Doe");
       registerRequest.setUsername("khlone");
       registerRequest.setPassword("password");
       userServices.register(registerRequest);
       assertEquals(1, userRepository.count());
       try {
           userServices.register(registerRequest);
       } catch (UserExistsException error) {
           assertEquals(error.getMessage(), String.format("Account with username %s is already in use", registerRequest.getUsername()));
       }

   }

    @Test
    public void registeredUsers_canLoginTest() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("John");
        registerRequest.setLastName("Doe");
        registerRequest.setUsername("khlone");
        registerRequest.setPassword("password");
        RegisterResponse userCreated = userServices.register(registerRequest);
        String userId = userCreated.getUserId();
        assertEquals(1, userRepository.count());

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("khlone");
        loginRequest.setPassword("password");
        userServices.login(loginRequest);
        assertEquals(userId, userCreated.getUserId());
    }

    @Test
    public void unregisteredUserCantLoginTest() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("khlone");
        loginRequest.setPassword("password");
        userServices.login(loginRequest);
        assertEquals(1, userRepository.count());
    }




    @Test
    public void usersCanAssignTasksToEachOtherTest() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("Joe");
        registerRequest.setFirstName("Doe");
        registerRequest.setUsername("plane");
        registerRequest.setPassword("passWord");
        RegisterResponse user = userServices.register(registerRequest);
        String userId = user.getUserId();
        System.out.println("first user id " + user.getUserId());
        assertEquals(1, userRepository.count());

        RegisterRequest reg2 = new RegisterRequest();
        reg2.setFirstName("Joe");
        reg2.setFirstName("Doe");
        reg2.setUsername("plane2");
        reg2.setPassword("passWord");
        RegisterResponse user2 = userServices.register(reg2);
        String user2Id = user2.getUserId();
        System.out.println("second user id " + user2.getUserId());
        assertEquals(2, userRepository.count());

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("plane");
        loginRequest.setPassword("passWord");
        userServices.login(loginRequest);
        assertEquals(userId, user.getUserId());

        LoginRequest loginRequest2 = new LoginRequest();
        loginRequest2.setUsername("plane2");
        loginRequest2.setPassword("passWord");
        userServices.login(loginRequest);
        assertEquals(user2Id, user2.getUserId());


        CreateTaskRequest createTaskRequest = new CreateTaskRequest();
        createTaskRequest.setTaskName("Call Tayo");
        createTaskRequest.setTaskDateTime("10/10/2028 10:00");
        createTaskRequest.setCategory(Category.PERSONAL);
        createTaskRequest.setContent("Call Tayo to inform her I'm breaking up");
        createTaskRequest.setPriority(Priority.LOW);
        createTaskRequest.setUserId(userId);
        CreateTaskResponse createTaskResponse = taskServices.createTask(createTaskRequest);
        String taskId = createTaskResponse.getTaskId();
        assertEquals(1, taskRepository.count());

        AssignTaskRequest assignTaskRequest = new AssignTaskRequest();
        assignTaskRequest.setTaskId(taskId);
        assignTaskRequest.setAssignerUsername("plane");
        assignTaskRequest.setAssigneeUsername("plane2");
        userServices.assignTask(assignTaskRequest);
        Task task = taskRepository.findByTaskId(createTaskResponse.getTaskId());
        assertNotNull(task);
        assertEquals(user2Id, task.getUserId());
    }
}