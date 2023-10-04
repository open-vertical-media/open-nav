package openverticalmedia.opennav.task.repository;

import openverticalmedia.opennav.task.entity.TaskItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskItemRepository extends JpaRepository<TaskItemEntity,Long> {
    TaskItemEntity findTopByStatusOrderByIdAsc(String status);
}
