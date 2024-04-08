package africa.todo.services;

import africa.todo.data.repositories.UserRepository;
import africa.todo.dataTransferObjects.requests.RegisterRequest;
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
    public void userRegisterWithSameDetailsTwice_repositoryThrowsUserExistException(){
       RegisterRequest registerRequest = new RegisterRequest();
       registerRequest.setUsername("khlone");
       registerRequest.setPassword("password");
       userServices.register(registerRequest);
       assertEquals(1,userRepository.count());
       try {
           userServices.register(registerRequest);
       }catch (UserExistsException error){
        assertEquals(error.getMessage(),String.format("Account with username %s is already in use",registerRequest.getUsername()));
       }

   }


}