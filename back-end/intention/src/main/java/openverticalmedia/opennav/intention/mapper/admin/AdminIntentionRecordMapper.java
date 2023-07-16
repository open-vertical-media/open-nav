package openverticalmedia.opennav.intention.mapper.admin;

import openverticalmedia.opennav.intention.dto.admin.AdminIntentionRecordDto;
import openverticalmedia.opennav.intention.entity.IntentionRecordEntity;

public class AdminIntentionRecordMapper {
    public static AdminIntentionRecordDto entityToDto(IntentionRecordEntity entity){
        AdminIntentionRecordDto dto=new AdminIntentionRecordDto();
        dto.setMessage(entity.getMessage());
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPath(entity.getPath());
        dto.setStatus(entity.getStatus());
        dto.setTelephone(entity.getTelephone());
        dto.setTime(entity.getCreateTime());
        dto.setRemark(entity.getRemark());
        return dto;
    }
}
