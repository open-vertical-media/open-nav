package openverticalmedia.opennav.intention.service.admin;

import openverticalmedia.opennav.intention.dto.admin.AdminIntentionQuotaData;
import openverticalmedia.opennav.intention.dto.admin.AdminIntentionQuotaDto;
import openverticalmedia.opennav.intention.entity.IntentionQuotaEntity;
import openverticalmedia.opennav.intention.mapper.admin.AdminIntentionQuotaMapper;
import openverticalmedia.opennav.intention.repository.IntentionQuotaRepository;
import openverticalmedia.opennav.model.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminIntentionQuotaService {
    @Autowired
    IntentionQuotaRepository repository;
    public Pager<AdminIntentionQuotaDto> query(int page,
                                               int size){
        Pager<AdminIntentionQuotaDto> result=new Pager<>();
        Page<IntentionQuotaEntity> entityPage = repository.findAll(PageRequest.of(page - 1, size));
        result.setCount(entityPage.getTotalElements());
        List<AdminIntentionQuotaDto> list = entityPage.stream()
                .map(AdminIntentionQuotaMapper::entityToDto)
                .collect(Collectors.toList());
        result.setData(list);
        return result;
    }
    public AdminIntentionQuotaDto get(long id){
        Optional<IntentionQuotaEntity> entityOptional = repository.findById(id);
        if(entityOptional.isPresent()){
            IntentionQuotaEntity entity = entityOptional.get();
            return AdminIntentionQuotaMapper.entityToDto(entity);
        }
        return null;
    }

    public long post( AdminIntentionQuotaData data){
        IntentionQuotaEntity entity = AdminIntentionQuotaMapper.dataToEntity(data);
        entity=repository.save(entity);
        return entity.getId();
    }

    public boolean put( long id, AdminIntentionQuotaData data){
        Optional<IntentionQuotaEntity> entityOptional = repository.findById(id);
        if(entityOptional.isPresent()){
            IntentionQuotaEntity entity = entityOptional.get();
            entity = AdminIntentionQuotaMapper.dataToEntity(entity,data);
            repository.save(entity);
            return true;
        }
        return false;
    }

    public void delete( long id){
        repository.deleteById(id);
    }
}
