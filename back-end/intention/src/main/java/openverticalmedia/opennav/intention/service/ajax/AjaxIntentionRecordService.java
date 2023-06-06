package openverticalmedia.opennav.intention.service.ajax;

import openverticalmedia.opennav.intention.dto.ajax.AjaxIntentionRecordData;
import openverticalmedia.opennav.intention.entity.IntentionRecordEntity;
import openverticalmedia.opennav.intention.mapper.ajax.AjaxIntentionRecordMapper;
import openverticalmedia.opennav.intention.repository.IntentionRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AjaxIntentionRecordService {
    @Autowired
    IntentionRecordRepository repository;
    public void post(AjaxIntentionRecordData data){
        //TODO 手机号短信验证；短信人机验证；频率限制
        IntentionRecordEntity entity = AjaxIntentionRecordMapper.dataToEntity(data);
        repository.save(entity);
        //TODO 线索分配
    }
}
