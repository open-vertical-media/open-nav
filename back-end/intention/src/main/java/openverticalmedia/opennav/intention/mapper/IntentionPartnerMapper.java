package openverticalmedia.opennav.intention.mapper;

import openverticalmedia.opennav.intention.dto.admin.IntentionPartnerData;
import openverticalmedia.opennav.intention.dto.admin.IntentionPartnerDto;
import openverticalmedia.opennav.intention.entity.record.IntentionPartnerEntity;

public class IntentionPartnerMapper {
    public static IntentionPartnerDto entityToDto(IntentionPartnerEntity entity){
        IntentionPartnerDto dto=new IntentionPartnerDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
    public static IntentionPartnerEntity dataToEntity(IntentionPartnerData data){
        IntentionPartnerEntity entity=new IntentionPartnerEntity();
        entity.setName(data.getName());
        return entity;
    }
    public static IntentionPartnerEntity dataToEntity(IntentionPartnerEntity entity,IntentionPartnerData data){
        entity.setName(data.getName());
        return entity;
    }
}
