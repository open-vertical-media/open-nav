package openverticalmedia.opennav.intention.manager.record;

import lombok.extern.slf4j.Slf4j;
import openverticalmedia.opennav.intention.entity.IntentionRecordEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class IntentionRecordHandler {
    @Autowired
    IntentionRecordPartnerChain partnerChain;
    @Autowired
    IntentionRecordSmsChain smsChain;
    @Autowired
    IntentionRecordQuotaChain quotaChain;

    public void addRecord(IntentionRecordEntity record) {
        try {
            record = partnerChain.proc(record);
            record = smsChain.proc(record);
            record= quotaChain.proc(record);
        } catch (Exception ex) {
            log.error("Record处理错误", ex);
        }
    }
}