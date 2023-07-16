package openverticalmedia.opennav.intention.manager;

import openverticalmedia.opennav.intention.entity.IntentionPartnerEntity;
import openverticalmedia.opennav.intention.entity.IntentionQuotaEntity;
import openverticalmedia.opennav.intention.repository.IntentionPartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class IntentionQuotaHandler {
    @Autowired
    IntentionPartnerRepository repository;

    @Async
    public void addQuota(IntentionQuotaEntity quota) {
        Optional<IntentionPartnerEntity> entityOptional = repository.findById(quota.getPartner().getId());
        if (entityOptional.isPresent()) {
            IntentionPartnerEntity entity = entityOptional.get();
            entity.setQuota(entity.getQuota() + quota.getNumber());
            repository.save(entity);
        }
    }

    @Async
    public void deleteQuota(IntentionQuotaEntity quota) {
        Optional<IntentionPartnerEntity> entityOptional = repository.findById(quota.getPartner().getId());
        if (entityOptional.isPresent()) {
            IntentionPartnerEntity entity = entityOptional.get();
            entity.setQuota(entity.getQuota() - quota.getNumber());
            repository.save(entity);
        }
    }
}