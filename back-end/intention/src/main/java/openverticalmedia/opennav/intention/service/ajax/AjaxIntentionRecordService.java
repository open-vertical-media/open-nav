package openverticalmedia.opennav.intention.service.ajax;

import openverticalmedia.opennav.intention.dto.ajax.AjaxIntentionRecordData;
import openverticalmedia.opennav.intention.repository.IntentionRecordRepository;
import openverticalmedia.opennav.intention.entity.IntentionRecordEntity;
import openverticalmedia.opennav.intention.manager.record.IntentionRecordHandler;
import openverticalmedia.opennav.intention.mapper.ajax.AjaxIntentionRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AjaxIntentionRecordService {
    @Autowired
    IntentionRecordRepository repository;
    @Autowired
    IntentionRecordHandler handler;

    public long post(AjaxIntentionRecordData data) {
        IntentionRecordEntity entity = AjaxIntentionRecordMapper.dataToEntity(data);
        entity = repository.save(entity);
        handler.addRecord(entity);
        return entity.getId();
    }
}
