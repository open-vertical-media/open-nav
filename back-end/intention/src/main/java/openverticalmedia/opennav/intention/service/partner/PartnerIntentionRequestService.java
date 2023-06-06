package openverticalmedia.opennav.intention.service.partner;

import openverticalmedia.opennav.intention.dto.partner.PartnerIntentionRequestData;
import openverticalmedia.opennav.intention.entity.IntentionRequestEntity;
import openverticalmedia.opennav.intention.mapper.partner.PartnerIntentionRequestMapper;
import openverticalmedia.opennav.intention.repository.IntentionRequestRepository;
import openverticalmedia.opennav.model.ManagerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
public class PartnerIntentionRequestService {
    @Autowired
    IntentionRequestRepository repository;
    public long post(ManagerModel manager,PartnerIntentionRequestData data){
        IntentionRequestEntity entity = PartnerIntentionRequestMapper.dataToEntity(data);
        entity.setPartnerId(manager.getId());
        entity = repository.save(entity);
        return entity.getId();
    }
}
