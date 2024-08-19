package org.ojl3g.controller;

import org.ojl3g.entity.ToDoList;
import org.ojl3g.service.ToDoListService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class ToDoListController {
    private final ToDoListService toDoListService;

    public ToDoListController(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    @GetMapping("/")
    public String toDoList(Model model) { // что такое Model model?
        model.addAttribute("toDoList", toDoListService.getAllToDoList()); // узнать на правильность написания данной строки?
        return "index";
    }

    @PostMapping("/todolist")
    public String createToDoList(@RequestParam String description,
                                 @RequestParam String importantThings,
                                 @RequestParam String simpleThings) {

        ToDoList toDoList = new ToDoList();

        toDoList.setDescription(description);
        toDoList.setImportantThings(importantThings);
        toDoList.setSimpleThings(simpleThings);

        toDoListService.saveToDoList(toDoList);

        return "redirect:/";

    }
}
