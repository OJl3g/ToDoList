package org.ojl3g.service;

import org.ojl3g.entity.ToDoList;
import org.ojl3g.repository.ToDoListRepository;

import java.util.List;

@org.springframework.stereotype.Service
public class ToDoListService {

    private final ToDoListRepository toDoListRepository;

    public ToDoListService(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    public void saveToDoList(ToDoList toDoList) {
        toDoListRepository.save(toDoList);
    }

    public List<ToDoList> getAllToDoList() {
        return toDoListRepository.findAll();
    }

}
