package openverticalmedia.opennav.intention.service.admin;

import cn.hutool.core.util.StrUtil;
import openverticalmedia.opennav.intention.mapper.admin.AdminIntentionPartnerMapper;
import openverticalmedia.opennav.intention.repository.IntentionPartnerRepository;
import openverticalmedia.opennav.common.exception.NotFoundException;
import openverticalmedia.opennav.intention.dto.admin.AdminIntentionPartnerData;
import openverticalmedia.opennav.intention.dto.admin.AdminIntentionPartnerDto;
import openverticalmedia.opennav.intention.entity.IntentionPartnerEntity;
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
public class AdminIntentionPartnerService {
    @Autowired
    IntentionPartnerRepository repository;
    public Pager<AdminIntentionPartnerDto> query(String name, int size, int page) {
        Pager<AdminIntentionPartnerDto> result = new Pager<>();
        Page<IntentionPartnerEntity> entityPage;
        PageRequest pageRequest = PageRequest.of(page - 1, size, Sort.by(Sort.Direction.DESC,"id"));
        if (StrUtil.isNotBlank(name)) {
            entityPage = repository.findAllByNameLike(name,pageRequest );
        } else {
            entityPage = repository.findAll(pageRequest);
        }
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
        throw new NotFoundException("找不到该伙伴:"+id);
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
