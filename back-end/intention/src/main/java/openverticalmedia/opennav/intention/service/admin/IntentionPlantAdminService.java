package openverticalmedia.opennav.intention.service.admin;

import openverticalmedia.opennav.intention.dto.admin.IntentionPlantData;
import openverticalmedia.opennav.intention.dto.admin.IntentionPlantDto;
import openverticalmedia.opennav.intention.entity.record.IntentionPlantEntity;
import openverticalmedia.opennav.intention.mapper.IntentionPlantMapper;
import openverticalmedia.opennav.intention.repository.IntentionPlantRepository;
import openverticalmedia.opennav.model.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IntentionPlantAdminService {
    @Autowired
    IntentionPlantRepository repository;

    public Pager<IntentionPlantDto> query(int page,
                                          int size) {
        Pager<IntentionPlantDto> result = new Pager<>();
        Page<IntentionPlantEntity> entityPage = repository.findAll(PageRequest.of(page - 1, size));
        result.setCount(entityPage.getTotalElements());
        List<IntentionPlantDto> list = entityPage.stream()
                .map(IntentionPlantMapper::entityToDto)
                .collect(Collectors.toList());
        result.setData(list);
        return result;
    }

    public IntentionPlantDto get(long id) {
        Optional<IntentionPlantEntity> entityOptional = repository.findById(id);
        if (entityOptional.isPresent()) {
            IntentionPlantEntity entity = entityOptional.get();
            return IntentionPlantMapper.entityToDto(entity);
        }
        return null;
    }

    public long post(IntentionPlantData data) {
        IntentionPlantEntity entity = IntentionPlantMapper.dataToEntity(data);
        entity = repository.save(entity);
        return entity.getId();
    }

    public boolean put(long id, IntentionPlantData data) {
        Optional<IntentionPlantEntity> entityOptional = repository.findById(id);
        if (entityOptional.isPresent()) {
            IntentionPlantEntity entity = entityOptional.get();
            entity = IntentionPlantMapper.dataToEntity(entity, data);
            repository.save(entity);
            return true;
        }
        return false;
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}