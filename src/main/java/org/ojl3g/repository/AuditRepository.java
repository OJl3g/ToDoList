package org.ojl3g.repository;

import org.ojl3g.entity.Audit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditRepository extends JpaRepository<Audit, Long> {
    //метод в интерфейсе репозитория AuditRepository,
    // используется для выполнения запроса в базу данных с целью получения списка записей из таблицы Audit, которые соответствуют конкретному taskId
    List<Audit> findByTaskId(Long taskId);
}
