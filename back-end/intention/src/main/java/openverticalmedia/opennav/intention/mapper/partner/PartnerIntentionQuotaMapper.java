package openverticalmedia.opennav.intention.mapper.partner;

import openverticalmedia.opennav.intention.dto.partner.PartnerIntentionQuotaDto;
import openverticalmedia.opennav.intention.entity.IntentionQuotaEntity;

public class PartnerIntentionQuotaMapper {
    public static PartnerIntentionQuotaDto entityToDto(IntentionQuotaEntity entity){
        PartnerIntentionQuotaDto dto=new PartnerIntentionQuotaDto();
        dto.setPartnerId(entity.getPartnerId());
        dto.setType(entity.getType());
        dto.setNumber(entity.getNumber());
        dto.setRecordId(entity.getRecordId());
        return dto;
    }
}
