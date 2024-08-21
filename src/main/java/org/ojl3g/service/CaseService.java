package org.ojl3g.service;

import org.ojl3g.entity.Case;
import org.ojl3g.repository.CaseRepository;

import java.util.List;

@org.springframework.stereotype.Service
public class CaseService {

    private final CaseRepository caseRepository;

    public CaseService(CaseRepository caseRepository) {
        this.caseRepository = caseRepository;
    }

    public void saveToDoList(Case aCase) {
        caseRepository.save(aCase);
    }

    public List<Case> getAllToDoList() {
        return caseRepository.findAll();
    }

}
