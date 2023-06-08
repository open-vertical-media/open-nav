package openverticalmedia.opennav.intention.manager;

import openverticalmedia.opennav.intention.dto.ajax.AjaxIntentionRecordData;
import org.springframework.stereotype.Component;

@Component
public class IntentionRecordChecker {
    public void checkRecord(AjaxIntentionRecordData data){
        //TODO 手机号短信验证；短信人机验证；频率限制
    }
}
