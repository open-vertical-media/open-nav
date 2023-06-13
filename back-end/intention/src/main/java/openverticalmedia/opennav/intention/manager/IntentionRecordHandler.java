package openverticalmedia.opennav.intention.manager;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import openverticalmedia.opennav.intention.config.IntentionProperties;
import openverticalmedia.opennav.intention.entity.IntentionPlantEntity;
import openverticalmedia.opennav.intention.entity.IntentionRecordEntity;
import openverticalmedia.opennav.intention.repository.IntentionRecordRepository;
import openverticalmedia.opennav.sdk.sms.SmsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class IntentionRecordHandler {
    @Autowired
    IntentionPlantProducer producer;
    @Autowired
    IntentionRecordRepository repository;
    @Autowired
    IntentionProperties properties;
    @Autowired
    SmsTemplate smsTemplate;


    public void addRecord(IntentionRecordEntity record){
        List<IntentionPlantEntity> plants = producer.get();
        Long partnerId=null;
        for(IntentionPlantEntity plant:plants){
            if(record.getPath().contains(plant.getPath())){
                partnerId = plant.getPartnerId();
                break;
            }
        }
        if(partnerId!=null) {
            record.setPartnerId(partnerId);
            repository.save(record);
            //TODO 通知客户
        }
        //TODO partnerName
        if(StrUtil.isNotBlank(properties.getTelephone())){
            Map<String,String> params=new HashMap<>();
            params.put("customer",record.getName());
            params.put("tel",record.getTelephone());
            params.put("server","");
//            smsTemplate.send(properties.getTelephone(), properties.getTemplateCode(),"");
        }
    }
}
