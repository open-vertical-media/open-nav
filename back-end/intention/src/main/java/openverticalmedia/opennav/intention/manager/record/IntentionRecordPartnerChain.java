package openverticalmedia.opennav.intention.manager.record;

import openverticalmedia.opennav.intention.entity.IntentionPlantEntity;
import openverticalmedia.opennav.intention.entity.IntentionRecordEntity;
import openverticalmedia.opennav.intention.manager.IntentionPlantProducer;
import openverticalmedia.opennav.intention.repository.IntentionRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IntentionRecordPartnerChain {
    @Autowired
    IntentionPlantProducer producer;
    @Autowired
    IntentionRecordRepository recordRepository;
    public IntentionRecordEntity proc(IntentionRecordEntity record){
        List<IntentionPlantEntity> plants = producer.get();
        Long partnerId = null;
        for (IntentionPlantEntity plant : plants) {
            if (record.getPath().contains(plant.getPath())) {
                partnerId = plant.getPartnerId();
                break;
            }
        }
        if (partnerId != null) {
            record.setPartnerId(partnerId);
            recordRepository.save(record);
        }
        return record;
    }
}
