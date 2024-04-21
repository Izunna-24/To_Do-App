package africa.todo.controllers;

import africa.todo.dataTransferObjects.requests.*;
import africa.todo.dataTransferObjects.responses.ApiResponse;
import africa.todo.exceptions.ToDoExceptions;
import africa.todo.services.TaskServices;
import africa.todo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
@Autowired
    private UserServices userServices;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest){
    try{
        var result = userServices.register(registerRequest);
        return new ResponseEntity<>(new ApiResponse(true, result),HttpStatus.CREATED);
    }catch (ToDoExceptions error){
        return new ResponseEntity<>(new ApiResponse(false,error.getMessage()), HttpStatus.BAD_REQUEST);
    }
    }
    @PostMapping("/set_task")
    public ResponseEntity<?> setTask(@RequestBody CreateTaskRequest createTaskRequest){
    try{
        var result = userServices.setTask(createTaskRequest);
        return new ResponseEntity<>(new ApiResponse(true, result),HttpStatus.CREATED);
    }catch (ToDoExceptions error){
        return new ResponseEntity<>(new ApiResponse(false,error.getMessage()), HttpStatus.BAD_REQUEST);
    }
    }
    @DeleteMapping("/delete_task")
    public ResponseEntity<?> deleteTask(@RequestBody DeleteTaskRequest deleteTaskRequest){
        try{
            var result = userServices.deleteTask(deleteTaskRequest);
            return new ResponseEntity<>(new ApiResponse(true, result),HttpStatus.OK);
        }catch (ToDoExceptions error){
            return new ResponseEntity<>(new ApiResponse(false,error.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get_task")
    public ResponseEntity<?> getTask(@RequestBody GetTaskRequest getTaskRequest){
        try{
            var result = userServices.getTask(getTaskRequest);
            return new ResponseEntity<>(new ApiResponse(true, result),HttpStatus.OK);
        }catch (ToDoExceptions error){
            return new ResponseEntity<>(new ApiResponse(false,error.getMessage()), HttpStatus.NOT_FOUND);
        }
    }
    @PatchMapping("/edit_task")
    public ResponseEntity<?> editTask(@RequestBody EditTaskRequest editTaskRequest){
        try{
            var result = userServices.editTask(editTaskRequest);
            return new ResponseEntity<>(new ApiResponse(true, result),HttpStatus.OK);
        }catch (ToDoExceptions error){
            return new ResponseEntity<>(new ApiResponse(false,error.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

}
