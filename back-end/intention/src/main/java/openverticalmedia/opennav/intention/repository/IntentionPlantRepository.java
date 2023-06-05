package openverticalmedia.opennav.intention.repository;

import openverticalmedia.opennav.intention.entity.record.IntentionPlantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntentionPlantRepository extends JpaRepository<IntentionPlantEntity,Long> {
}
