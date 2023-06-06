package openverticalmedia.opennav.intention.service.admin;

import openverticalmedia.opennav.intention.dto.admin.AdminIntentionPartnerData;
import openverticalmedia.opennav.intention.dto.admin.AdminIntentionPartnerDto;
import openverticalmedia.opennav.intention.entity.IntentionPartnerEntity;
import openverticalmedia.opennav.intention.mapper.admin.AdminIntentionPartnerMapper;
import openverticalmedia.opennav.intention.repository.IntentionPartnerRepository;
import openverticalmedia.opennav.model.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminIntentionPartnerService {
    @Autowired
    IntentionPartnerRepository repository;
    public Pager<AdminIntentionPartnerDto> query(String name, int size, int page){
        Pager<AdminIntentionPartnerDto> result=new Pager<>();
        Page<IntentionPartnerEntity> entityPage = repository.findAllByNameLike(name, PageRequest.of(page - 1, size));
        result.setCount(entityPage.getTotalElements());
        List<AdminIntentionPartnerDto> list = entityPage.stream()
                .map(AdminIntentionPartnerMapper::entityToDto)
                .collect(Collectors.toList());
        result.setData(list);
        return result;
    }
    public AdminIntentionPartnerDto get(long id){
        Optional<IntentionPartnerEntity> entityOptional = repository.findById(id);
        if(entityOptional.isPresent()){
            IntentionPartnerEntity entity = entityOptional.get();
            return AdminIntentionPartnerMapper.entityToDto(entity);
        }
        return null;
    }
    public long post(AdminIntentionPartnerData data){
        //TODO 校验名称是否重复
        IntentionPartnerEntity entity = AdminIntentionPartnerMapper.dataToEntity(data);
        entity = repository.save(entity);
        return entity.getId();
    }
    public boolean put(long id, AdminIntentionPartnerData data) {
        Optional<IntentionPartnerEntity> entityOptional = repository.findById(id);
        if (entityOptional.isPresent()) {
            IntentionPartnerEntity entity = entityOptional.get();
            entity = AdminIntentionPartnerMapper.dataToEntity(entity, data);
            repository.save(entity);
            return true;
        }
        return false;
    }
    public void delete(long id){
        repository.deleteById(id);
    }
}
