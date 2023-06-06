package openverticalmedia.opennav.intention.mapper.admin;

import openverticalmedia.opennav.intention.dto.admin.AdminIntentionQuotaData;
import openverticalmedia.opennav.intention.dto.admin.AdminIntentionQuotaDto;
import openverticalmedia.opennav.intention.entity.IntentionQuotaEntity;

public class AdminIntentionQuotaMapper {
    public static AdminIntentionQuotaDto entityToDto(IntentionQuotaEntity entity){
        AdminIntentionQuotaDto dto=new AdminIntentionQuotaDto();
        dto.setId(entity.getId());
        dto.setNumber(entity.getNumber());
        dto.setRecordId(entity.getRecordId());
        dto.setType(entity.getType());
        dto.setPartnerId(entity.getPartnerId());
        return dto;
    }
    public static IntentionQuotaEntity dataToEntity(AdminIntentionQuotaData data){
        IntentionQuotaEntity entity=new IntentionQuotaEntity();
        entity.setNumber(data.getNumber());
        entity.setType(data.getType());
        entity.setRecordId(data.getRecordId());
        entity.setRecordId(data.getRecordId());
        return entity;
    }
    public static IntentionQuotaEntity dataToEntity(IntentionQuotaEntity entity, AdminIntentionQuotaData data){
        entity.setNumber(data.getNumber());
        entity.setType(data.getType());
        entity.setRecordId(data.getRecordId());
        entity.setRecordId(data.getRecordId());
        return entity;
    }
}
