package openverticalmedia.opennav.intention.service.admin;

import openverticalmedia.opennav.intention.dto.admin.AdminIntentionRecordPart;
import openverticalmedia.opennav.intention.mapper.admin.AdminIntentionRecordMapper;
import openverticalmedia.opennav.intention.repository.IntentionRecordRepository;
import openverticalmedia.opennav.common.model.Pager;
import openverticalmedia.opennav.intention.dto.admin.AdminIntentionRecordDto;
import openverticalmedia.opennav.intention.entity.IntentionRecordEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminIntentionRecordService {
    @Autowired
    IntentionRecordRepository repository;

    public Pager<AdminIntentionRecordDto> query(Long partnerId, String name, String telephone,int page,int size){
        Pager<AdminIntentionRecordDto> result=new Pager<>();
        PageRequest pageRequest = PageRequest.of(page - 1, size, Sort.by(Sort.Direction.DESC,"id"));
        Page<IntentionRecordEntity> entityPage = repository.query(partnerId, name, telephone, pageRequest);
        result.setCount(entityPage.getTotalElements());
        List<AdminIntentionRecordDto> list = entityPage.stream()
                .map(AdminIntentionRecordMapper::entityToDto)
                .collect(Collectors.toList());
        result.setData(list);
        return result;
    }
    public boolean patch(long id, AdminIntentionRecordPart part){
        Optional<IntentionRecordEntity> entityOptional = repository.findById(id);
        if(entityOptional.isPresent()){
            IntentionRecordEntity entity = entityOptional.get();
            entity.setRemark(part.getRemark());
            repository.save(entity);
            return true;
        }
        return false;
    }
}
