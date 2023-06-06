package openverticalmedia.opennav.intention.service.admin;

import openverticalmedia.opennav.intention.dto.admin.AdminIntentionRecordDto;
import openverticalmedia.opennav.intention.entity.IntentionRecordEntity;
import openverticalmedia.opennav.intention.mapper.admin.AdminIntentionRecordMapper;
import openverticalmedia.opennav.intention.repository.IntentionRecordRepository;
import openverticalmedia.opennav.model.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminIntentionRecordService {
    @Autowired
    IntentionRecordRepository repository;

    public Pager<AdminIntentionRecordDto> query(Long partnerId,String name,String telephone){
        Pager<AdminIntentionRecordDto> result=new Pager<>();
        Page<IntentionRecordEntity> entityPage = repository.query(partnerId, name, telephone);
        result.setCount(entityPage.getTotalElements());
        List<AdminIntentionRecordDto> list = entityPage.stream()
                .map(AdminIntentionRecordMapper::entityToDto)
                .collect(Collectors.toList());
        result.setData(list);
        return result;
    }
}
