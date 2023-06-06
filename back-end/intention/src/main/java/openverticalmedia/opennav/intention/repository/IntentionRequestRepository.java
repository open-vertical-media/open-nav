package openverticalmedia.opennav.intention.repository;

import openverticalmedia.opennav.intention.entity.IntentionRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntentionRequestRepository extends JpaRepository<IntentionRequestEntity,Long> {

}
