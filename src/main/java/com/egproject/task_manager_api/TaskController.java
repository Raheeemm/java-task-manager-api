package com.egproject.task_manager_api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import  org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController{
    private final List<Task> taskList= new ArrayList<>();

    @GetMapping
    public List<Task> getalltasks(){
        return taskList;
    }

    @PostMapping
    public Task createTask(@RequestBody Task task){
        taskList.add(task);
        return task;
    }
    @GetMapping("/{id}")
    public Task getTaskbyId(@PathVariable int id){
        for (Task task : taskList){
            if(task.getId()==id){
                return task;
            }
        }return null;
    }

    @DeleteMapping("/{id}")
    public String deleteTaskbyId(@PathVariable int id){
        taskList.removeIf(task -> task.getId()==id);
        return "deleted successfully";

    }
}