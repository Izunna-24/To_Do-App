package africa.todo.services;

import africa.todo.data.repositories.MyUserRepository;
import africa.todo.dataTransferObjects.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyUserServicesImpl implements MyUserServices{

    @Autowired
    private MyUserRepository myUserRepository;
    @Override
    public void register(RegisterRequest registerRequest) {

    }
}
