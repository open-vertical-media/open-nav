package openverticalmedia.opennav.intention.service;

import openverticalmedia.opennav.intention.dto.IntentionData;
import openverticalmedia.opennav.intention.entity.record.IntentionRecordEntity;
import openverticalmedia.opennav.intention.mapper.IntentionMapper;
import openverticalmedia.opennav.intention.repository.IntentionRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntentionAjaxService {
    @Autowired
    IntentionRecordRepository repository;
    public void post(IntentionData data){
        //TODO 手机号短信验证；短信人机验证；频率限制
        //TODO 线索分配
        IntentionRecordEntity entity = IntentionMapper.dataToEntity(data);
        repository.save(entity);
    }
}
