package openverticalmedia.opennav.intention.service.admin;

import openverticalmedia.opennav.intention.manager.IntentionQuotaHandler;
import openverticalmedia.opennav.common.exception.NotFoundException;
import openverticalmedia.opennav.intention.dto.admin.AdminIntentionQuotaData;
import openverticalmedia.opennav.intention.dto.admin.AdminIntentionQuotaDto;
import openverticalmedia.opennav.intention.entity.IntentionQuotaEntity;
import openverticalmedia.opennav.intention.mapper.admin.AdminIntentionQuotaMapper;
import openverticalmedia.opennav.intention.repository.IntentionQuotaRepository;
import openverticalmedia.opennav.common.model.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminIntentionQuotaService {
    @Autowired
    IntentionQuotaRepository repository;
    @Autowired
    IntentionQuotaHandler manager;

    public Pager<AdminIntentionQuotaDto> query(int page,
                                               int size) {
        Pager<AdminIntentionQuotaDto> result = new Pager<>();
        PageRequest pageRequest = PageRequest.of(page - 1, size, Sort.by(Sort.Direction.DESC,"id"));
        Page<IntentionQuotaEntity> entityPage = repository.findAll(pageRequest);
        result.setCount(entityPage.getTotalElements());
        List<AdminIntentionQuotaDto> list = entityPage.stream()
                .map(AdminIntentionQuotaMapper::entityToDto)
                .collect(Collectors.toList());
        result.setData(list);
        return result;
    }

    public AdminIntentionQuotaDto get(long id) {
        Optional<IntentionQuotaEntity> entityOptional = repository.findById(id);
        if (entityOptional.isPresent()) {
            IntentionQuotaEntity entity = entityOptional.get();
            return AdminIntentionQuotaMapper.entityToDto(entity);
        }
        throw new NotFoundException("找不到该额度："+id);
    }

    public long post(AdminIntentionQuotaData data) {
        IntentionQuotaEntity entity = AdminIntentionQuotaMapper.dataToEntity(data);
        entity = repository.save(entity);
        manager.addQuota(entity);
        return entity.getId();
    }

    public void delete(long id) {
        Optional<IntentionQuotaEntity> entityOptional = repository.findById(id);
        if (entityOptional.isPresent()) {
            IntentionQuotaEntity entity = entityOptional.get();
            manager.deleteQuota(entity);
            repository.deleteById(id);
        }
        throw new NotFoundException("找不到该额度："+id);
    }
}