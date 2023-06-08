package openverticalmedia.opennav.intention.manager;

import openverticalmedia.opennav.intention.repository.IntentionPlantRepository;
import openverticalmedia.opennav.intention.entity.IntentionRecordEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IntentionRecordHandler {
    @Autowired
    IntentionPlantRepository repository;

    public void addRecord(IntentionRecordEntity record){
        //TODO 线索分配
    }
}
