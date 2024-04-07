package africa.todo.data.repositories;

import africa.todo.data.models.MyUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.junit.jupiter.api.Assertions.*;
@DataMongoTest
class MyUserRepositoryTest {
    @Autowired
    private MyUserRepository myUserRepository;


    @Test
    public void myUserCanBeSavedInTheDBTest(){
        myUserRepository.deleteAll();
        MyUser myUser = new MyUser();
        myUserRepository.save(myUser);
        assertEquals(1,myUserRepository.count());
    }

}