package openverticalmedia.opennav.intention.service.admin;

import openverticalmedia.opennav.intention.dto.admin.IntentionQuotaData;
import openverticalmedia.opennav.intention.dto.admin.IntentionQuotaDto;
import openverticalmedia.opennav.intention.entity.record.IntentionQuotaEntity;
import openverticalmedia.opennav.intention.mapper.IntentionQuotaMapper;
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
public class IntentionQuotaAdminService {
    @Autowired
    IntentionQuotaRepository repository;
    public Pager<IntentionQuotaDto> query(int page,
                                          int size){
        Pager<IntentionQuotaDto> result=new Pager<>();
        Page<IntentionQuotaEntity> entityPage = repository.findAll(PageRequest.of(page - 1, size));
        result.setCount(entityPage.getTotalElements());
        List<IntentionQuotaDto> list = entityPage.stream()
                .map(IntentionQuotaMapper::entityToDto)
                .collect(Collectors.toList());
        result.setData(list);
        return result;
    }
    public IntentionQuotaDto get( long id){
        Optional<IntentionQuotaEntity> entityOptional = repository.findById(id);
        if(entityOptional.isPresent()){
            IntentionQuotaEntity entity = entityOptional.get();
            return IntentionQuotaMapper.entityToDto(entity);
        }
        return null;
    }

    public long post( IntentionQuotaData data){
        IntentionQuotaEntity entity = IntentionQuotaMapper.dataToEntity(data);
        entity=repository.save(entity);
        return entity.getId();
    }

    public boolean put( long id, IntentionQuotaData data){
        Optional<IntentionQuotaEntity> entityOptional = repository.findById(id);
        if(entityOptional.isPresent()){
            IntentionQuotaEntity entity = entityOptional.get();
            entity = IntentionQuotaMapper.dataToEntity(entity,data);
            repository.save(entity);
            return true;
        }
        return false;
    }

    public void delete( long id){
        repository.deleteById(id);
    }
}
