package openverticalmedia.opennav.intention.service.partner;

import openverticalmedia.opennav.common.exception.NotFoundException;
import openverticalmedia.opennav.common.model.PartnerModel;
import openverticalmedia.opennav.intention.entity.IntentionPartnerEntity;
import openverticalmedia.opennav.intention.repository.IntentionPartnerRepository;
import openverticalmedia.opennav.common.model.ManagerModel;
import openverticalmedia.opennav.intention.dto.partner.PartnerIntentionPartnerDto;
import openverticalmedia.opennav.intention.mapper.partner.PartnerIntentionPartnerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PartnerIntentionPartnerService {
    @Autowired
    IntentionPartnerRepository repository;
    public PartnerIntentionPartnerDto get(PartnerModel partner){
        Optional<IntentionPartnerEntity> partnerOptional = repository.findById(partner.getId());
        if(partnerOptional.isPresent()){
            IntentionPartnerEntity entity = partnerOptional.get();
            return PartnerIntentionPartnerMapper.entityToDto(entity);
        }
        throw new NotFoundException("找不到该伙伴："+partner.getId());
    }
}
