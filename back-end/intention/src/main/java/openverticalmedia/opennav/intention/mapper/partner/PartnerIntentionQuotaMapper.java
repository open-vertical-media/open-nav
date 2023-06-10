package openverticalmedia.opennav.intention.mapper.partner;

import openverticalmedia.opennav.intention.entity.IntentionQuotaEntity;
import openverticalmedia.opennav.intention.dto.partner.PartnerIntentionQuotaDto;

public class PartnerIntentionQuotaMapper {
    public static PartnerIntentionQuotaDto entityToDto(IntentionQuotaEntity entity){
        PartnerIntentionQuotaDto dto=new PartnerIntentionQuotaDto();
        dto.setType(entity.getType());
        dto.setNumber(entity.getNumber());
        return dto;
    }
}
