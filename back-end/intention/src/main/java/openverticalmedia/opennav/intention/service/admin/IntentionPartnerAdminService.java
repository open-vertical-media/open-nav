package openverticalmedia.opennav.intention.service.admin;

import openverticalmedia.opennav.intention.dto.admin.IntentionPartnerData;
import openverticalmedia.opennav.intention.dto.admin.IntentionPartnerDto;
import openverticalmedia.opennav.intention.entity.record.IntentionPartnerEntity;
import openverticalmedia.opennav.intention.mapper.IntentionPartnerMapper;
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
public class IntentionPartnerAdminService {
    @Autowired
    IntentionPartnerRepository repository;
    public Pager<IntentionPartnerDto> query(String name, int size, int page){
        Pager<IntentionPartnerDto> result=new Pager<>();
        Page<IntentionPartnerEntity> entityPage = repository.findAllByNameLike(name, PageRequest.of(page - 1, size));
        result.setCount(entityPage.getTotalElements());
        List<IntentionPartnerDto> list = entityPage.stream()
                .map(IntentionPartnerMapper::entityToDto)
                .collect(Collectors.toList());
        result.setData(list);
        return result;
    }
    public IntentionPartnerDto get(long id){
        Optional<IntentionPartnerEntity> entityOptional = repository.findById(id);
        if(entityOptional.isPresent()){
            IntentionPartnerEntity entity = entityOptional.get();
            return IntentionPartnerMapper.entityToDto(entity);
        }
        return null;
    }
    public long post(IntentionPartnerData data){
        //TODO 校验名称是否重复
        IntentionPartnerEntity entity = IntentionPartnerMapper.dataToEntity(data);
        entity = repository.save(entity);
        return entity.getId();
    }
    public boolean put(long id,IntentionPartnerData data) {
        Optional<IntentionPartnerEntity> entityOptional = repository.findById(id);
        if (entityOptional.isPresent()) {
            IntentionPartnerEntity entity = entityOptional.get();
            entity = IntentionPartnerMapper.dataToEntity(entity, data);
            repository.save(entity);
            return true;
        }
        return false;
    }
    public void delete(long id){
        repository.deleteById(id);
    }
}
