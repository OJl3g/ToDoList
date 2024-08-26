package org.ojl3g.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long taskId;

    @Column(nullable = false)
    private String action;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    public Audit(Long taskId, String action) {
        this.taskId = taskId;
        this.action = action;
        this.timestamp = LocalDateTime.now();
    }
}
