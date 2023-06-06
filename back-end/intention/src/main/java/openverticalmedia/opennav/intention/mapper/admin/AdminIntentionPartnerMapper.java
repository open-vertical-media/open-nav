package openverticalmedia.opennav.intention.mapper.admin;

import openverticalmedia.opennav.intention.dto.admin.AdminIntentionPartnerData;
import openverticalmedia.opennav.intention.dto.admin.AdminIntentionPartnerDto;
import openverticalmedia.opennav.intention.entity.IntentionPartnerEntity;

public class AdminIntentionPartnerMapper {
    public static AdminIntentionPartnerDto entityToDto(IntentionPartnerEntity entity){
        AdminIntentionPartnerDto dto=new AdminIntentionPartnerDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
    public static IntentionPartnerEntity dataToEntity(AdminIntentionPartnerData data){
        IntentionPartnerEntity entity=new IntentionPartnerEntity();
        entity.setName(data.getName());
        return entity;
    }
    public static IntentionPartnerEntity dataToEntity(IntentionPartnerEntity entity, AdminIntentionPartnerData data){
        entity.setName(data.getName());
        return entity;
    }
}
