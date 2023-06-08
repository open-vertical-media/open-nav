package openverticalmedia.opennav.intention.mapper.partner;

import openverticalmedia.opennav.intention.dto.partner.PartnerIntentionRequestDto;
import openverticalmedia.opennav.intention.dto.partner.PartnerIntentionRequestData;
import openverticalmedia.opennav.intention.entity.IntentionRequestEntity;

public class PartnerIntentionRequestMapper {
    public static IntentionRequestEntity dataToEntity(PartnerIntentionRequestData data){
        IntentionRequestEntity entity=new IntentionRequestEntity();
        entity.setPartnerId(data.getPartnerId());
        entity.setRelationId(data.getRelationId());
        entity.setRelationType(data.getRelationType());
        return entity;
    }
    public static PartnerIntentionRequestDto entityToDto(IntentionRequestEntity entity){
        PartnerIntentionRequestDto dto=new PartnerIntentionRequestDto();
        dto.setId(entity.getId());
        dto.setPartnerId(entity.getPartnerId());
        dto.setRelationId(entity.getRelationId());
        dto.setRelationType(entity.getRelationType());
        return dto;
    }
}
