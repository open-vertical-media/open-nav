package openverticalmedia.opennav.advert.service.admin;

import openverticalmedia.opennav.advert.dto.admin.AdminAdvertScheduleDto;
import openverticalmedia.opennav.advert.entity.ScheduleEntity;
import openverticalmedia.opennav.advert.mapper.AdvertScheduleMapper;
import openverticalmedia.opennav.advert.repository.AdvertScheduleRepository;
import openverticalmedia.opennav.common.exception.NotFoundException;
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
public class AdminAdvertScheduleService {
    @Autowired
    AdvertScheduleRepository repository;

    public Pager<AdminAdvertScheduleDto> query(int page, int size) {
        Pager<AdminAdvertScheduleDto> result = new Pager<>();
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"));
        Page<ScheduleEntity> entityPage = repository.findAll(pageRequest);
        List<AdminAdvertScheduleDto> list = entityPage.stream()
                .map(AdvertScheduleMapper::entityToAdmin)
                .collect(Collectors.toList());
        result.setData(list);
        return result;
    }

    public AdminAdvertScheduleDto get(long id) {
        Optional<ScheduleEntity> entityOptional = repository.findById(id);
        if (!entityOptional.isPresent()) {
            throw new NotFoundException("找不到该排期:" + id);
        }
        return AdvertScheduleMapper.entityToAdmin(entityOptional.get());
    }

    public long post(AdminAdvertScheduleDto data) {
        ScheduleEntity entity = AdvertScheduleMapper.adminToEntity(data);
        entity = repository.save(entity);
        return entity.getId();
    }

    public boolean put(long id, AdminAdvertScheduleDto data) {
        Optional<ScheduleEntity> entityOptional = repository.findById(id);
        if (!entityOptional.isPresent()) {
            throw new NotFoundException("找不到该排期:" + id);
        }
        ScheduleEntity entity = entityOptional.get();
        entity = AdvertScheduleMapper.adminToEntity(entity, data);
        repository.save(entity);
        return true;
    }
}