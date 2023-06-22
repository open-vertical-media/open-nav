package openverticalmedia.opennav.intention.manager;

import openverticalmedia.opennav.common.exception.LogicException;
import openverticalmedia.opennav.intention.entity.IntentionPartnerEntity;
import openverticalmedia.opennav.intention.entity.IntentionRecordEntity;
import openverticalmedia.opennav.intention.repository.IntentionPartnerRepository;
import openverticalmedia.opennav.intention.entity.IntentionRequestEntity;
import openverticalmedia.opennav.intention.repository.IntentionRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class IntentionRequestHandler {
    @Autowired
    IntentionPartnerRepository partnerRepository;
    @Autowired
    IntentionRecordRepository recordRepository;
    @Autowired
    IntentionRecordRepository requestRepository;

    public boolean addRequest(IntentionRequestEntity request) {
        if(!request.getRelationType().equals("record")){
            throw new LogicException("申请类型错误");
        }
        Optional<IntentionRecordEntity> recordOptional = recordRepository.findById(request.getRelationId());
        if(!recordOptional.isPresent()){
            throw new LogicException("找不到申请的资源");
        }
        IntentionRecordEntity record = recordOptional.get();
        if(!record.getStatus().equals("CREATED")){
            throw new LogicException("申请的资源状态错误,可以已经申请过了");
        }
        Optional<IntentionPartnerEntity> partnerOptional = partnerRepository.findById(request.getPartnerId());
        IntentionPartnerEntity partner = partnerOptional.get();
        if(partner.getQuota()<=0) {
            throw new LogicException("额度不足请及时充值");
        }
        partner.setQuota(partner.getQuota()-1);
        partnerRepository.save(partner);
        record.setStatus("SUCCESS");
        recordRepository.save(record);
        return true;
    }
}
