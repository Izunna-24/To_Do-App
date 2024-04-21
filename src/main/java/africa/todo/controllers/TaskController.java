package africa.todo.controllers;


import africa.todo.dataTransferObjects.requests.ViewTaskRequest;
import africa.todo.dataTransferObjects.responses.ApiResponse;
import africa.todo.exceptions.ToDoExceptions;
import africa.todo.services.TaskServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    @Autowired
    private TaskServices taskServices;


    @GetMapping("/view_task")
    public ResponseEntity<?> viewTask(@RequestBody ViewTaskRequest viewTaskRequest){
        try{
            var result = taskServices.viewTask(viewTaskRequest);
            return new ResponseEntity<>(new ApiResponse(true, result),HttpStatus.CREATED);
        }catch (ToDoExceptions error){
            return new ResponseEntity<>(new ApiResponse(false,error.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/find_task")
    public ResponseEntity<?> findAll(){
        try{
            var result = taskServices.findAllTask();
            return new ResponseEntity<>(new ApiResponse(true, result),HttpStatus.CREATED);
        }catch (ToDoExceptions error){
            return new ResponseEntity<>(new ApiResponse(false,error.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}


