package openverticalmedia.opennav.intention.service.admin;

import openverticalmedia.opennav.intention.mapper.admin.AdminIntentionRecordMapper;
import openverticalmedia.opennav.intention.repository.IntentionRecordRepository;
import openverticalmedia.opennav.common.model.Pager;
import openverticalmedia.opennav.intention.dto.admin.AdminIntentionRecordDto;
import openverticalmedia.opennav.intention.entity.IntentionRecordEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminIntentionRecordService {
    @Autowired
    IntentionRecordRepository repository;

    public Pager<AdminIntentionRecordDto> query(Long partnerId, String name, String telephone,int page,int size){
        Pager<AdminIntentionRecordDto> result=new Pager<>();
        Page<IntentionRecordEntity> entityPage = repository.query(partnerId, name, telephone, PageRequest.of(page-1,size));
        result.setCount(entityPage.getTotalElements());
        List<AdminIntentionRecordDto> list = entityPage.stream()
                .map(AdminIntentionRecordMapper::entityToDto)
                .collect(Collectors.toList());
        result.setData(list);
        return result;
    }
}
