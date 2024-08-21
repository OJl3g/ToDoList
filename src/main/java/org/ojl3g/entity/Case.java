package org.ojl3g.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Идея : Список дел (сохраняет важные и простые дела в базе данных).
 */

@Entity
@Data
@NoArgsConstructor
//сущность, для того, что бы от нее наследовались и использовалась одна таблица
// для всех классов наследников.
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//добавляет в таблицу столбец для идентификации объекта и тип объекта будет строковый.
@DiscriminatorColumn(name = "case_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description; //описание дел

    public Case(String description) {
        this.description = description;
    }




}
