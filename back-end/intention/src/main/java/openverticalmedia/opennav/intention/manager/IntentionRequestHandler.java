package openverticalmedia.opennav.intention.manager;

import openverticalmedia.opennav.intention.repository.IntentionPartnerRepository;
import openverticalmedia.opennav.intention.entity.IntentionRequestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class IntentionRequestHandler {
    @Autowired
    IntentionPartnerRepository repository;

    @Async
    public void addRequest(IntentionRequestEntity request) {
        repository.syncQuota(request.getPartnerId(), -1);
    }
}
