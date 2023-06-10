package openverticalmedia.opennav.intention.mapper.ajax;

import openverticalmedia.opennav.intention.dto.ajax.AjaxIntentionRecordData;
import openverticalmedia.opennav.intention.entity.IntentionRecordEntity;


public class AjaxIntentionRecordMapper {
    public static IntentionRecordEntity dataToEntity(AjaxIntentionRecordData data){
        IntentionRecordEntity entity=new IntentionRecordEntity();
        entity.setMessage(data.getMessage());
        entity.setName(data.getName());
        entity.setPath(data.getPath());
        entity.setTelephone(data.getTelephone());
        return entity;
    }
    public static IntentionRecordEntity dataToEntity(IntentionRecordEntity entity, AjaxIntentionRecordData data){
        entity.setMessage(data.getMessage());
        entity.setName(data.getName());
        entity.setPath(data.getPath());
        entity.setTelephone(data.getTelephone());
        return entity;
    }
}
