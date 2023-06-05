package openverticalmedia.opennav.intention.mapper;

import openverticalmedia.opennav.intention.dto.admin.IntentionQuotaData;
import openverticalmedia.opennav.intention.dto.admin.IntentionQuotaDto;
import openverticalmedia.opennav.intention.entity.record.IntentionQuotaEntity;

public class IntentionQuotaMapper {
    public static IntentionQuotaDto entityToDto(IntentionQuotaEntity entity){
        IntentionQuotaDto dto=new IntentionQuotaDto();
        dto.setId(entity.getId());
        dto.setNumber(entity.getNumber());
        dto.setRecordId(entity.getRecordId());
        dto.setType(entity.getType());
        dto.setPartnerId(entity.getPartnerId());
        return dto;
    }
    public static IntentionQuotaEntity dataToEntity(IntentionQuotaData data){
        IntentionQuotaEntity entity=new IntentionQuotaEntity();
        entity.setNumber(data.getNumber());
        entity.setType(data.getType());
        entity.setRecordId(data.getRecordId());
        entity.setRecordId(data.getRecordId());
        return entity;
    }
    public static IntentionQuotaEntity dataToEntity(IntentionQuotaEntity entity,IntentionQuotaData data){
        entity.setNumber(data.getNumber());
        entity.setType(data.getType());
        entity.setRecordId(data.getRecordId());
        entity.setRecordId(data.getRecordId());
        return entity;
    }
}
