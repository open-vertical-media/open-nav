package openverticalmedia.opennav.intention.manager;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import openverticalmedia.opennav.intention.config.IntentionProperties;
import openverticalmedia.opennav.intention.entity.IntentionPartnerEntity;
import openverticalmedia.opennav.intention.entity.IntentionPlantEntity;
import openverticalmedia.opennav.intention.entity.IntentionRecordEntity;
import openverticalmedia.opennav.intention.repository.IntentionPartnerRepository;
import openverticalmedia.opennav.intention.repository.IntentionRecordRepository;
import openverticalmedia.opennav.sdk.sms.SmsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Component
public class IntentionRecordHandler {
    @Autowired
    IntentionPlantProducer producer;
    @Autowired
    IntentionRecordRepository recordRepository;
    @Autowired
    IntentionPartnerRepository partnerRepository;
    @Autowired
    IntentionProperties properties;
    @Autowired
    SmsTemplate smsTemplate;

    public void addRecord(IntentionRecordEntity record) {
        try {
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
                //TODO 通知客户
            }
            if (StrUtil.isBlank(properties.getTelephone())) {
                return;
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
        } catch (Exception ex) {
            log.error("Record处理错误", ex);
        }
    }
}