package openverticalmedia.opennav.config.mapper;

import openverticalmedia.opennav.config.dto.AdminConfigPropertyDto;
import openverticalmedia.opennav.config.entity.ConfigPropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class ConfigPropertyMapper {
    public AdminConfigPropertyDto entityToDto(ConfigPropertyEntity entity){
        AdminConfigPropertyDto dto=new AdminConfigPropertyDto();
        dto.setKey(entity.getKey());
        dto.setValue(entity.getKey());
        dto.setVersion(entity.getVersion());
        return dto;
    }
}
