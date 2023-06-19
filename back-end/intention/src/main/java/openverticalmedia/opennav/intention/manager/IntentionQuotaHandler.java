package openverticalmedia.opennav.intention.manager;

import openverticalmedia.opennav.intention.entity.IntentionQuotaEntity;
import openverticalmedia.opennav.intention.repository.IntentionPartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class IntentionQuotaHandler {
    @Autowired
    IntentionPartnerRepository repository;

    @Async
    public void addQuota(IntentionQuotaEntity quota) {
        repository.syncQuota(quota.getPartner().getId(), quota.getNumber());
    }

    @Async
    public void deleteQuota(IntentionQuotaEntity quota) {
        repository.syncQuota(quota.getPartner().getId(), -quota.getNumber());
    }
}