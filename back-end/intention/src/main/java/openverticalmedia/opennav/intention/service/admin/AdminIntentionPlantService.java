package openverticalmedia.opennav.intention.service.admin;

import openverticalmedia.opennav.intention.dto.admin.AdminIntentionPlantData;
import openverticalmedia.opennav.intention.dto.admin.AdminIntentionPlantDto;
import openverticalmedia.opennav.intention.entity.IntentionPlantEntity;
import openverticalmedia.opennav.intention.mapper.admin.AdminIntentionPlantMapper;
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
public class AdminIntentionPlantService {
    @Autowired
    IntentionPlantRepository repository;

    public Pager<AdminIntentionPlantDto> query(int page,
                                               int size) {
        Pager<AdminIntentionPlantDto> result = new Pager<>();
        Page<IntentionPlantEntity> entityPage = repository.findAll(PageRequest.of(page - 1, size));
        result.setCount(entityPage.getTotalElements());
        List<AdminIntentionPlantDto> list = entityPage.stream()
                .map(AdminIntentionPlantMapper::entityToDto)
                .collect(Collectors.toList());
        result.setData(list);
        return result;
    }

    public AdminIntentionPlantDto get(long id) {
        Optional<IntentionPlantEntity> entityOptional = repository.findById(id);
        if (entityOptional.isPresent()) {
            IntentionPlantEntity entity = entityOptional.get();
            return AdminIntentionPlantMapper.entityToDto(entity);
        }
        return null;
    }

    public long post(AdminIntentionPlantData data) {
        IntentionPlantEntity entity = AdminIntentionPlantMapper.dataToEntity(data);
        entity = repository.save(entity);
        return entity.getId();
    }

    public boolean put(long id, AdminIntentionPlantData data) {
        Optional<IntentionPlantEntity> entityOptional = repository.findById(id);
        if (entityOptional.isPresent()) {
            IntentionPlantEntity entity = entityOptional.get();
            entity = AdminIntentionPlantMapper.dataToEntity(entity, data);
            repository.save(entity);
            return true;
        }
        return false;
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}