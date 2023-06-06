package openverticalmedia.opennav.intention.service.partner;

import openverticalmedia.opennav.intention.dto.partner.PartnerIntentionRecordDto;
import openverticalmedia.opennav.intention.entity.IntentionEntity;
import openverticalmedia.opennav.intention.entity.IntentionRecordEntity;
import openverticalmedia.opennav.intention.mapper.partner.PartnerIntentionRecordMapper;
import openverticalmedia.opennav.intention.repository.IntentionRecordRepository;
import openverticalmedia.opennav.model.ManagerModel;
import openverticalmedia.opennav.model.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartnerIntentionRecordService {
    @Autowired
    IntentionRecordRepository repository;

    public Pager<PartnerIntentionRecordDto> query(ManagerModel managerModel, int page, int size) {
        Page<IntentionRecordEntity> entityPage = repository.findByPartnerId(managerModel.getId(), PageRequest.of(page - 1, size));
        Pager<PartnerIntentionRecordDto> result = new Pager<>();
        result.setCount(entityPage.getTotalElements());
        List<PartnerIntentionRecordDto> list = entityPage.stream()
                .map(PartnerIntentionRecordMapper::entityToDto)
                .collect(Collectors.toList());
        result.setData(list);
        return result;
    }
}