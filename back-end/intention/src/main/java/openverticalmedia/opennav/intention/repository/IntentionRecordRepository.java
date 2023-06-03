package openverticalmedia.opennav.intention.repository;

import openverticalmedia.opennav.intention.entity.IntentionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntentionRecordRepository extends JpaRepository<IntentionEntity,Long> {
}
