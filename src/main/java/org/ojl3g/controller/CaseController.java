package org.ojl3g.controller;

import org.ojl3g.entity.*;
import org.ojl3g.repository.AuditRepository;
import org.ojl3g.service.CaseService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@org.springframework.stereotype.Controller
public class CaseController {
    private final CaseService caseService;
    private final AuditRepository auditRepository;

    public CaseController(CaseService caseService, AuditRepository auditRepository) {
        this.caseService = caseService;
        this.auditRepository = auditRepository;
    }

    @GetMapping("/")
    //Model oбъект, что бы передавать данные на html страницу
    public String index(Model model) {
        List<Case> doList = caseService.getAllToDoList();

        List<Case> listSimple = doList.stream().filter(task -> task instanceof SimpleMatter).toList();
        List<Case> listMatter = doList.stream().filter(task -> task instanceof ImportantMatter).toList();
        List<Case> listUrgent = doList.stream().filter(task -> task instanceof UrgentMatter).toList();

        //Эти строки добавляют данные в модель Model, которая используется для передачи данных из контроллера в представление (HTML-шаблон).
        model.addAttribute("listSimple", listSimple);
        model.addAttribute("listMatter", listMatter);
        model.addAttribute("listUrgent", listUrgent);

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

        // Логирование создания задачи
        auditRepository.save(new Audit(caseObject.getId(), "Создание задачи"));

        return "redirect:/";

    }

    @GetMapping("/task_history")
    public String taskHistory(@RequestParam Long id,
                              @RequestParam Model model) {

        List<Audit> auditLogs = auditRepository.findByTaskId(id);
        model.addAttribute("auditLogs", auditLogs);
        return "task_history";
    }
}
