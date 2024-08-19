package org.ojl3g.repository;

import org.ojl3g.entity.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListRepository extends JpaRepository<ToDoList, Integer> {
}
