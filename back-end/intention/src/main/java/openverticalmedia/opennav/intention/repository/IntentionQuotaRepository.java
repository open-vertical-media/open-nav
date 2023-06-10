package openverticalmedia.opennav.intention.repository;

import openverticalmedia.opennav.intention.entity.IntentionQuotaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntentionQuotaRepository extends JpaRepository<IntentionQuotaEntity,Long> {
    Page<IntentionQuotaEntity> queryByPartnerId(long partnerId, Pageable pageable);
    Page<IntentionQuotaEntity> queryByPartnerIdAndType(long partnerId,String type, Pageable pageable);
}
