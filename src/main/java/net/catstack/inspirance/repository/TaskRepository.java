package net.catstack.inspirance.repository;

import net.catstack.inspirance.domain.model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskModel, Long> {
    @Query(value = "SELECT * FROM tasks WHERE ((:theme_id is null or theme_id = CAST(CAST(:theme_id AS TEXT) AS BIGINT)) and (:category_id is null"
            + " or category_id = CAST(CAST(:category_id AS TEXT) AS BIGINT)))", nativeQuery = true)
    List<TaskModel> findTaskByThemeAndCategory(@Param("theme_id") Long themeId, @Param("category_id") Long categoryId);
}
