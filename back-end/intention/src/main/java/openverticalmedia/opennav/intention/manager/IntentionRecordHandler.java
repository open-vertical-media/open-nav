package openverticalmedia.opennav.intention.manager;

import openverticalmedia.opennav.intention.entity.IntentionPlantEntity;
import openverticalmedia.opennav.intention.entity.IntentionRecordEntity;
import openverticalmedia.opennav.intention.repository.IntentionRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IntentionRecordHandler {
    @Autowired
    IntentionPlantProducer producer;
    @Autowired
    IntentionRecordRepository repository;

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
            //TODO 短信通知partner
        }
        //TODO 短信通知manager
    }
}
