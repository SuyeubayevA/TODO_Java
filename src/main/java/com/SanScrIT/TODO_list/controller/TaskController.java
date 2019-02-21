package com.SanScrIT.TODO_list.controller;

import com.SanScrIT.TODO_list.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TaskController {

    @Autowired
    public TaskService taskService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/tasks")
    public String getAllTasks(Model model){
        model.addAttribute("task",taskService.findAll());
        return "tasksList";
    }
}
