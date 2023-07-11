package openverticalmedia.opennav.advert.service.admin;

import openverticalmedia.opennav.advert.dto.admin.AdminAdvertScheduleDto;
import openverticalmedia.opennav.advert.entity.ScheduleEntity;
import openverticalmedia.opennav.advert.repository.AdvertScheduleRepository;
import openverticalmedia.opennav.common.model.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AdminAdvertScheduleService {
    @Autowired
    AdvertScheduleRepository repository;
    public Pager<AdminAdvertScheduleDto> query(int page,int size){
        Pager<AdminAdvertScheduleDto> result=new Pager<>();
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"));
        Page<ScheduleEntity> entityPage = repository.findAll(pageRequest);
//        entityPage.stream()
//                .map()
        return result;
    }
}
