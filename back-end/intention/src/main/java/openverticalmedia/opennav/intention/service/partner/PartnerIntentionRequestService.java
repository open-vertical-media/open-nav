package openverticalmedia.opennav.intention.service.partner;

import openverticalmedia.opennav.intention.dto.partner.PartnerIntentionRequestDto;
import openverticalmedia.opennav.intention.manager.IntentionRequestHandler;
import openverticalmedia.opennav.intention.repository.IntentionRequestRepository;
import openverticalmedia.opennav.common.model.ManagerModel;
import openverticalmedia.opennav.common.exception.NotFoundException;
import openverticalmedia.opennav.intention.dto.partner.PartnerIntentionRequestData;
import openverticalmedia.opennav.intention.entity.IntentionRequestEntity;
import openverticalmedia.opennav.intention.mapper.partner.PartnerIntentionRequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PartnerIntentionRequestService {
    @Autowired
    IntentionRequestRepository repository;
    @Autowired
    IntentionRequestHandler manager;

    public long post(ManagerModel managerModel, PartnerIntentionRequestData data) {
        IntentionRequestEntity entity = PartnerIntentionRequestMapper.dataToEntity(data);
        entity.setPartnerId(managerModel.getId());
        entity = repository.save(entity);
        manager.addRequest(entity);
        return entity.getId();
    }
    public PartnerIntentionRequestDto get(long id){
        //TODO 归属验证
        Optional<IntentionRequestEntity> entityOptional = repository.findById(id);
        if(entityOptional.isPresent()){
            IntentionRequestEntity entity = entityOptional.get();
            return PartnerIntentionRequestMapper.entityToDto(entity);
        }
        throw new NotFoundException("找不到该申请："+id);
    }
}