package org.ojl3g.controller;

import org.ojl3g.service.CaseService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class CaseController {
    private final CaseService caseService;

    public CaseController(CaseService caseService) {
        this.caseService = caseService;
    }

    @GetMapping("/")
    //Model oбъект, что бы передавать данные на html страницу
    public String index(Model model) {
        return "index";
    }

    @PostMapping("/todolist")
    public String createToDoList(@RequestParam String description){


        return "redirect:/";

    }
}
