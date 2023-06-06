package openverticalmedia.opennav.intention.mapper.partner;

import openverticalmedia.opennav.intention.dto.partner.PartnerIntentionRecordDto;
import openverticalmedia.opennav.intention.entity.IntentionRecordEntity;

public class PartnerIntentionRecordMapper {
    public static PartnerIntentionRecordDto entityToDto(IntentionRecordEntity entity){
        PartnerIntentionRecordDto dto=new PartnerIntentionRecordDto();
        dto.setPartnerId(entity.getPartnerId());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        dto.setMessage(entity.getMessage());
        dto.setTelephone(entity.getTelephone());
        return dto;
    }
}