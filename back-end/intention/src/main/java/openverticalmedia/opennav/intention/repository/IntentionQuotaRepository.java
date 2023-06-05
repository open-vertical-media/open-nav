package openverticalmedia.opennav.intention.repository;

import openverticalmedia.opennav.intention.entity.record.IntentionQuotaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntentionQuotaRepository extends JpaRepository<IntentionQuotaEntity,Long> {
}
