package openverticalmedia.opennav.intention.mapper.admin;

import openverticalmedia.opennav.intention.dto.admin.AdminIntentionPlantData;
import openverticalmedia.opennav.intention.dto.admin.AdminIntentionPlantDto;
import openverticalmedia.opennav.intention.entity.IntentionPlantEntity;

public class AdminIntentionPlantMapper {
    public static AdminIntentionPlantDto entityToDto(IntentionPlantEntity entity){
        AdminIntentionPlantDto dto=new AdminIntentionPlantDto();
        dto.setPath(entity.getPath());
        dto.setPartnerId(entity.getPartnerId());
        return dto;
    }
    public static IntentionPlantEntity dataToEntity(AdminIntentionPlantData data){
        IntentionPlantEntity entity=new IntentionPlantEntity();
        entity.setPath(data.getPath());
        entity.setPartnerId(data.getPartnerId());
        return entity;
    }
    public static IntentionPlantEntity dataToEntity(IntentionPlantEntity entity, AdminIntentionPlantData data){
        entity.setPath(data.getPath());
        entity.setPartnerId(data.getPartnerId());
        return entity;
    }
}
