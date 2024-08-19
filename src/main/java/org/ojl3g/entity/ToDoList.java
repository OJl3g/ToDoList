package org.ojl3g.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Идея : Список дел (сохраняет важные и простые дела в базе данных).
 */

@Entity
@Data
@Table(name = "todolists")
@NoArgsConstructor
public class ToDoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description; //описание дел

    private String importantThings; //важные дела
    private String simpleThings; //простые дела

    public ToDoList(String description, String importantThings, String simpleThings) {
        this.description = description;
        this.importantThings = importantThings;
        this.simpleThings = simpleThings;
    }
}
