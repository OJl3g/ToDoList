package org.ojl3g.controller;

import org.ojl3g.entity.Case;
import org.ojl3g.entity.ImportantMatter;
import org.ojl3g.entity.SimpleMatter;
import org.ojl3g.entity.UrgentMatter;
import org.ojl3g.service.CaseService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@org.springframework.stereotype.Controller
public class CaseController {
    private final CaseService caseService;

    public CaseController(CaseService caseService) {
        this.caseService = caseService;
    }

    @GetMapping("/")
    //Model oбъект, что бы передавать данные на html страницу
    public String index(Model model) {
        List<Case> doList = caseService.getAllToDoList();

        List<Case> listSimple = doList.stream().filter(task -> task instanceof SimpleMatter).toList();
        List<Case> listMatter = doList.stream().filter(task -> task instanceof ImportantMatter).toList();
        List<Case> listUrgent = doList.stream().filter(task -> task instanceof UrgentMatter).toList();

        return "index";
    }


    @GetMapping("/add_case")
    public String addCase(Model model) {
        return "add_case";
    }

    @PostMapping("/add_case")
    public String addCase(@RequestParam String description,
                          @RequestParam String type) {

        Case caseObject;
        switch (type) {
            case "simple" -> caseObject = new SimpleMatter(description);
            case "important" -> caseObject = new ImportantMatter(description);
            case "urgent" -> caseObject = new UrgentMatter(description);
            default -> caseObject = null;
        }
        caseService.saveToDoList(caseObject);

        return "redirect:/";

    }
}
