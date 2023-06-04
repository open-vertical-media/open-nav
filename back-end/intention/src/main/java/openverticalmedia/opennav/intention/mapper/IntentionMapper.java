package openverticalmedia.opennav.intention.mapper;

import openverticalmedia.opennav.intention.dto.IntentionData;
import openverticalmedia.opennav.intention.entity.record.IntentionRecordEntity;


public class IntentionMapper {
    public static IntentionRecordEntity dataToEntity(IntentionData data){
        IntentionRecordEntity entity=new IntentionRecordEntity();
        entity.setMessage(data.getMessage());
        entity.setName(data.getName());
        entity.setTelephone(data.getTelephone());
        return entity;
    }
}
