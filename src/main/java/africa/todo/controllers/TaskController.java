package africa.todo.controllers;


import africa.todo.dataTransferObjects.requests.CreateTaskRequest;
import africa.todo.dataTransferObjects.requests.ViewAllTaskRequest;
import africa.todo.dataTransferObjects.responses.ApiResponse;
import africa.todo.dataTransferObjects.responses.CreateTaskResponse;
import africa.todo.exceptions.ToDoExceptions;
import africa.todo.services.TaskServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    @Autowired
    private TaskServices taskServices;


    @GetMapping("/view_task")
    public ResponseEntity<?> viewAllTask(@RequestBody ViewAllTaskRequest viewAllTaskRequest){
        try{
            var result = taskServices.viewAllTask(viewAllTaskRequest);
            return new ResponseEntity<>(new ApiResponse(true, result),HttpStatus.CREATED);
        }catch (ToDoExceptions error){
            return new ResponseEntity<>(new ApiResponse(false,error.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/find_task")
    public ResponseEntity<?> findAll() {
        try {
            var result = taskServices.findAllTask();
            return new ResponseEntity<>(new ApiResponse(true, result), HttpStatus.CREATED);
        } catch (ToDoExceptions error) {
            return new ResponseEntity<>(new ApiResponse(false, error.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

            @PostMapping("/create_task")
            public ResponseEntity<?> createTask (@RequestBody CreateTaskRequest createTaskRequest){
                try {
                    CreateTaskResponse createTaskResponse = taskServices.createTask(createTaskRequest);
                    return new ResponseEntity<>(new ApiResponse(true, createTaskResponse), HttpStatus.CREATED);
                } catch (ToDoExceptions error) {
                    return new ResponseEntity<>(new ApiResponse(false, error.getMessage()), HttpStatus.BAD_REQUEST);
                }
            }


        }

