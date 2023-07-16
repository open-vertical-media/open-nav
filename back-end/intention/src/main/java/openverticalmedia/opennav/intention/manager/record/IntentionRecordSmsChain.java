package openverticalmedia.opennav.intention.manager.record;

import cn.hutool.core.util.StrUtil;
import openverticalmedia.opennav.intention.config.IntentionProperties;
import openverticalmedia.opennav.intention.entity.IntentionPartnerEntity;
import openverticalmedia.opennav.intention.entity.IntentionRecordEntity;
import openverticalmedia.opennav.intention.repository.IntentionPartnerRepository;
import openverticalmedia.opennav.sdk.sms.SmsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class IntentionRecordSmsChain{
    @Autowired
    IntentionProperties properties;
    @Autowired
    SmsTemplate smsTemplate;
    @Autowired
    IntentionPartnerRepository partnerRepository;
    public IntentionRecordEntity proc(IntentionRecordEntity record){
        if (StrUtil.isBlank(properties.getTelephone())) {
            return record;
        }
        Map<String, String> params = new HashMap<>();
        params.put("customer", record.getName());
        params.put("tel", record.getTelephone());
        if (record.getPartnerId() != null) {
            Optional<IntentionPartnerEntity> partnerOptional = partnerRepository.findById(record.getPartnerId());
            if (partnerOptional.isPresent()) {
                params.put("server", partnerOptional.get().getName());
            } else {
                params.put("server", "客户不存在-" + record.getPartnerId());
            }
        } else {
            params.put("server", record.getPath().replace(".html",""));
        }
        List<String> tels = StrUtil.split(properties.getTelephone(), ",");
        for (String tel : tels) {
            smsTemplate.send(properties.getSign(), tel, properties.getTemplateCode(), params);
        }
        return record;
    }
}
