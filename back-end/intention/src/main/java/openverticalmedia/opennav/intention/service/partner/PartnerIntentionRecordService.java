package openverticalmedia.opennav.intention.service.partner;

import openverticalmedia.opennav.common.model.PartnerModel;
import openverticalmedia.opennav.intention.mapper.partner.PartnerIntentionRecordMapper;
import openverticalmedia.opennav.intention.repository.IntentionRecordRepository;
import openverticalmedia.opennav.common.model.ManagerModel;
import openverticalmedia.opennav.common.model.Pager;
import openverticalmedia.opennav.intention.dto.partner.PartnerIntentionRecordDto;
import openverticalmedia.opennav.intention.entity.IntentionRecordEntity;
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

    public Pager<PartnerIntentionRecordDto> query(PartnerModel partner, int page, int size) {
        Page<IntentionRecordEntity> entityPage = repository.findByPartnerId(partner.getId(), PageRequest.of(page - 1, size));
        Pager<PartnerIntentionRecordDto> result = new Pager<>();
        result.setCount(entityPage.getTotalElements());
        List<PartnerIntentionRecordDto> list = entityPage.stream()
                .map(PartnerIntentionRecordMapper::entityToDto)
                .collect(Collectors.toList());
        result.setData(list);
        return result;
    }
}