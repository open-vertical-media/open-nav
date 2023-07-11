package openverticalmedia.opennav.advert.service.ajax;

import cn.hutool.core.util.ReUtil;
import openverticalmedia.opennav.advert.dto.ajax.AjaxAdvertScheduleData;
import openverticalmedia.opennav.advert.dto.ajax.AjaxAdvertScheduleDto;
import openverticalmedia.opennav.advert.entity.ScheduleEntity;
import openverticalmedia.opennav.advert.mapper.AdvertScheduleMapper;
import openverticalmedia.opennav.advert.repository.AdvertScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AjaxAdvertScheduleService {
    @Autowired
    AdvertScheduleRepository repository;
    public List<AjaxAdvertScheduleDto> get(AjaxAdvertScheduleData data){
        List<ScheduleEntity> entityList = repository.findAll();
        return entityList.stream()
                .filter(e -> ReUtil.isMatch(e.getUrl(), data.getUrl()))
                .sorted(Comparator.comparing(ScheduleEntity::getBlockIndex))
                .map(AdvertScheduleMapper::entityToDto)
                .collect(Collectors.toList());
    }
}
