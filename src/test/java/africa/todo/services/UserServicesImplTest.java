package africa.todo.services;

import africa.todo.data.models.Category;
import africa.todo.data.models.Priority;
import africa.todo.data.repositories.UserRepository;
import africa.todo.dataTransferObjects.requests.CreateTaskRequest;
import africa.todo.dataTransferObjects.requests.LoginRequest;
import africa.todo.dataTransferObjects.requests.RegisterRequest;
import africa.todo.dataTransferObjects.responses.RegisterResponse;
import africa.todo.exceptions.ToDoExceptions;
import africa.todo.exceptions.UserExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServicesImplTest {
    @Autowired
    private UserServices userServices;
    @Autowired
    private UserRepository userRepository;

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
    public void usersCanAssignTasksToEachOtherTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("khlone");
        registerRequest.setPassword("password");
        userServices.register(registerRequest);
        assertEquals(1,userRepository.count());

        CreateTaskRequest createTaskRequest = new CreateTaskRequest();
        createTaskRequest.setTaskName("Call Tayo");

        createTaskRequest.setTaskDateTime("10/10/2028 10:00");

        createTaskRequest.setCategory(Category.PERSONAL);
        createTaskRequest.setContent("Call Tayo to inform her I'm breaking up");
        createTaskRequest.setPriority(Priority.LOW);
        createTaskRequest.setUserId("userId");
        //taskServices.createTask(createTaskRequest);


    }


}