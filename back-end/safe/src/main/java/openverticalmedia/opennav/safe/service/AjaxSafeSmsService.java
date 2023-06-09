package openverticalmedia.opennav.safe.service;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.RandomUtil;
import openverticalmedia.opennav.safe.config.SafeProperties;
import openverticalmedia.opennav.safe.dto.AjaxSafeSmsData;
import openverticalmedia.opennav.safe.dto.AjaxSafeSmsDto;
import openverticalmedia.opennav.sdk.sms.SmsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class AjaxSafeSmsService {
    @Autowired
    SmsTemplate smsTemplate;
    @Autowired
    SafeProperties properties;
    @Autowired
    StringRedisTemplate redisTemplate;

    public AjaxSafeSmsDto sms(AjaxSafeSmsData data) {
        String code = RandomUtil.randomNumbers(6);
        Map<String, String> params = new HashMap<>();
        params.put("code", code);
        smsTemplate.send(data.getTel(), properties.getSmsTemplateCode(), params);
        String token = UUID.fastUUID().toString(true);
        //5分钟有效
        redisTemplate.opsForValue().set("code:" + token, code, 5, TimeUnit.MINUTES);
        redisTemplate.opsForValue().set("tel:" + token, data.getTel(), 5, TimeUnit.MINUTES);
        AjaxSafeSmsDto result = new AjaxSafeSmsDto();
        result.setToken(token);
        return result;
    }
}
