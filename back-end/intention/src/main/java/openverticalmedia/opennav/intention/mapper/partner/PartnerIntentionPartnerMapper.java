package openverticalmedia.opennav.intention.mapper.partner;

import openverticalmedia.opennav.intention.dto.partner.PartnerIntentionPartnerDto;
import openverticalmedia.opennav.intention.entity.IntentionPartnerEntity;

public class PartnerIntentionPartnerMapper {
    public static PartnerIntentionPartnerDto entityToDto(IntentionPartnerEntity entity){
        PartnerIntentionPartnerDto dto=new PartnerIntentionPartnerDto();
        dto.setName(entity.getName());
        dto.setQuota(entity.getQuota());
        dto.setId(entity.getId());
        return dto;
    }
}
