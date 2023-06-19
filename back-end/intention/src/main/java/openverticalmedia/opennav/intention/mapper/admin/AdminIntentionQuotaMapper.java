package openverticalmedia.opennav.intention.mapper.admin;

import openverticalmedia.opennav.intention.dto.admin.AdminIntentionQuotaData;
import openverticalmedia.opennav.intention.dto.admin.AdminIntentionQuotaDto;
import openverticalmedia.opennav.intention.entity.IntentionPartnerEntity;
import openverticalmedia.opennav.intention.entity.IntentionQuotaEntity;

public class AdminIntentionQuotaMapper {
    public static AdminIntentionQuotaDto entityToDto(IntentionQuotaEntity entity){
        AdminIntentionQuotaDto dto=new AdminIntentionQuotaDto();
        dto.setId(entity.getId());
        dto.setNumber(entity.getNumber());
        dto.setType(entity.getType());
        IntentionPartnerEntity partner = entity.getPartner();
        if(partner!=null){
            dto.setPartnerId(partner.getId());
            dto.setPartnerName(partner.getName());
        }
        return dto;
    }
    public static IntentionQuotaEntity dataToEntity(AdminIntentionQuotaData data){
        IntentionQuotaEntity entity=new IntentionQuotaEntity();
        entity.setNumber(data.getNumber());
        entity.setType(data.getType());
        IntentionPartnerEntity partner=new IntentionPartnerEntity();
        {
            partner.setId(data.getPartnerId());
        }
        entity.setPartner(partner);
        return entity;
    }
}
