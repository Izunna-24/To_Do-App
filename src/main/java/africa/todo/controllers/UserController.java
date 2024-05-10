package africa.todo.controllers;

import africa.todo.dataTransferObjects.requests.*;
import africa.todo.dataTransferObjects.responses.*;
import africa.todo.exceptions.ToDoExceptions;
import africa.todo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "*")
public class UserController {
@Autowired
    private UserServices userServices;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        try {
            var registerResponse = userServices.register(registerRequest);
            return new ResponseEntity<>(new ApiResponse(true, registerResponse), CREATED);
        } catch (ToDoExceptions error) {
            return new ResponseEntity<>(new ApiResponse(false, error.getMessage()), BAD_REQUEST);
        }
    }
        @PostMapping("/loggin")
        public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
            try{
                LoginResponse loginResponse = userServices.login(loginRequest);
                return new ResponseEntity<>(new ApiResponse(true, loginResponse), CREATED);
            }catch (ToDoExceptions error){
                return new ResponseEntity<>(new ApiResponse(false,error.getMessage()), BAD_REQUEST);
            }



        }
    @DeleteMapping("/delete_task")
    public ResponseEntity<?> deleteTask(@RequestBody DeleteTaskRequest deleteTaskRequest){
        try{
            DeleteTaskResponse deleteTaskResponse = userServices.deleteTask(deleteTaskRequest);
            return new ResponseEntity<>(new ApiResponse(true, deleteTaskResponse),HttpStatus.OK);
        }catch (ToDoExceptions error){
            return new ResponseEntity<>(new ApiResponse(false,error.getMessage()), BAD_REQUEST);
        }
    }

    @GetMapping("/get_task")
    public ResponseEntity<?> getTask(@RequestBody GetTaskRequest getTaskRequest){
        try{
            GetTaskResponse getTaskResponse = userServices.getTask(getTaskRequest);
            return new ResponseEntity<>(new ApiResponse(true, getTaskResponse),HttpStatus.OK);
        }catch (ToDoExceptions error){
            return new ResponseEntity<>(new ApiResponse(false,error.getMessage()), HttpStatus.NOT_FOUND);
        }
    }
    @PatchMapping("/edit_task")
    public ResponseEntity<?> editTask(@RequestBody EditTaskRequest editTaskRequest){
        try{
            EditTaskResponse editTaskResponse = userServices.editTask(editTaskRequest);
            return new ResponseEntity<>(new ApiResponse(true, editTaskResponse),HttpStatus.OK);
        }catch (ToDoExceptions error){
            return new ResponseEntity<>(new ApiResponse(false,error.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

}
