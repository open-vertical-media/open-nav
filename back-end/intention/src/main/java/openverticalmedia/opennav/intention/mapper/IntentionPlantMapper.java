package openverticalmedia.opennav.intention.mapper;

import openverticalmedia.opennav.intention.dto.admin.IntentionPlantData;
import openverticalmedia.opennav.intention.dto.admin.IntentionPlantDto;
import openverticalmedia.opennav.intention.entity.record.IntentionPlantEntity;

public class IntentionPlantMapper {
    public static IntentionPlantDto entityToDto(IntentionPlantEntity entity){
        IntentionPlantDto dto=new IntentionPlantDto();
        dto.setPath(entity.getPath());
        dto.setPartnerId(entity.getPartnerId());
        return dto;
    }
    public static IntentionPlantEntity dataToEntity(IntentionPlantData data){
        IntentionPlantEntity entity=new IntentionPlantEntity();
        entity.setPath(data.getPath());
        entity.setPartnerId(data.getPartnerId());
        return entity;
    }
    public static IntentionPlantEntity dataToEntity(IntentionPlantEntity entity,IntentionPlantData data){
        entity.setPath(data.getPath());
        entity.setPartnerId(data.getPartnerId());
        return entity;
    }
}
