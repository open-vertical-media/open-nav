package openverticalmedia.opennav.config.service;

import openverticalmedia.opennav.common.model.Pager;
import openverticalmedia.opennav.config.dto.AdminConfigPropertyDto;
import openverticalmedia.opennav.config.entity.ConfigPropertyEntity;
import openverticalmedia.opennav.config.mapper.ConfigPropertyMapper;
import openverticalmedia.opennav.config.repository.ConfigPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminConfigPropertyService {
    @Autowired
    ConfigPropertyRepository repository;
    @Autowired
    ConfigPropertyMapper mapper;
    public Pager<AdminConfigPropertyDto> get(int page, int size){
        Page<ConfigPropertyEntity> entityPage = repository.findAll(PageRequest.of(page - 1, size));
        List<AdminConfigPropertyDto> list = entityPage.stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
        Pager<AdminConfigPropertyDto> result=new Pager<>();
        result.setCount(entityPage.getTotalElements());
        result.setData(list);
        return result;
    }
}
