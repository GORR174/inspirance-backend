package net.catstack.inspirance.repository;

import net.catstack.inspirance.domain.model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskModel, Long> {
}
