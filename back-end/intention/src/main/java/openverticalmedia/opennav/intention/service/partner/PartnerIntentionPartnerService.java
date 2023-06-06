package openverticalmedia.opennav.intention.service.partner;

import openverticalmedia.opennav.intention.dto.partner.PartnerIntentionPartnerDto;
import openverticalmedia.opennav.intention.entity.IntentionPartnerEntity;
import openverticalmedia.opennav.intention.mapper.partner.PartnerIntentionPartnerMapper;
import openverticalmedia.opennav.intention.repository.IntentionPartnerRepository;
import openverticalmedia.opennav.model.ManagerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PartnerIntentionPartnerService {
    @Autowired
    IntentionPartnerRepository repository;
    public PartnerIntentionPartnerDto get(ManagerModel manager){
        Optional<IntentionPartnerEntity> partnerOptional = repository.findById(manager.getId());
        if(partnerOptional.isPresent()){
            IntentionPartnerEntity entity = partnerOptional.get();
            PartnerIntentionPartnerDto result = PartnerIntentionPartnerMapper.entityToDto(entity);
            return result;
        }
        return null;
    }
}
