package openverticalmedia.opennav.intention.manager.record;

import lombok.extern.slf4j.Slf4j;
import openverticalmedia.opennav.common.exception.LogicException;
import openverticalmedia.opennav.intention.entity.IntentionPartnerEntity;
import openverticalmedia.opennav.intention.entity.IntentionRecordEntity;
import openverticalmedia.opennav.intention.repository.IntentionPartnerRepository;
import openverticalmedia.opennav.intention.repository.IntentionRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class IntentionRecordQuotaChain {
    @Autowired
    IntentionPartnerRepository partnerRepository;
    @Autowired
    IntentionRecordRepository recordRepository;
    public IntentionRecordEntity proc(IntentionRecordEntity record){
        if (record.getPartnerId() == null) {
            return record;
        }
        Optional<IntentionPartnerEntity> partnerOptional = partnerRepository.findById(record.getPartnerId());
        if (!partnerOptional.isPresent()) {
            return record;
        }
        IntentionPartnerEntity partner = partnerOptional.get();
        if(partner.getQuota()<=0) {
            //额度不足请及时充值
            log.warn("额度不足:{}-{}", partner.getName(), partner.getQuota());
            return record;
        }
        partner.setQuota(partner.getQuota()-1);
        partnerRepository.save(partner);
        record.setStatus("SUCCESS");
        recordRepository.save(record);
        return record;
    }
}
