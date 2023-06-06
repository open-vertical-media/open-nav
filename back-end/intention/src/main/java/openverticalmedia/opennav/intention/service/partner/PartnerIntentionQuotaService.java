package openverticalmedia.opennav.intention.service.partner;

import openverticalmedia.opennav.intention.dto.partner.PartnerIntentionQuotaDto;
import openverticalmedia.opennav.intention.entity.IntentionQuotaEntity;
import openverticalmedia.opennav.intention.mapper.partner.PartnerIntentionQuotaMapper;
import openverticalmedia.opennav.intention.repository.IntentionQuotaRepository;
import openverticalmedia.opennav.model.ManagerModel;
import openverticalmedia.opennav.model.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartnerIntentionQuotaService {
    @Autowired
    IntentionQuotaRepository repository;
    public Pager<PartnerIntentionQuotaDto> query(ManagerModel manager, int page, int size){
        Pager<PartnerIntentionQuotaDto> result=new Pager<>();
        Page<IntentionQuotaEntity> entityPage = repository.query(manager.getId(), PageRequest.of(page - 1, size));
        result.setCount(entityPage.getTotalElements());
        List<PartnerIntentionQuotaDto> list = entityPage.stream()
                .map(PartnerIntentionQuotaMapper::entityToDto)
                .collect(Collectors.toList());
        result.setData(list);
        return result;
    }
}
