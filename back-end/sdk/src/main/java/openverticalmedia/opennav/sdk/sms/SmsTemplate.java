package openverticalmedia.opennav.sdk.sms;

import cn.hutool.json.JSONUtil;
import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import lombok.extern.slf4j.Slf4j;
import openverticalmedia.opennav.sdk.config.SdkProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
public class SmsTemplate {
    final Client client;
    final SdkProperties properties;
    public SmsTemplate(Client client,SdkProperties properties){
        this.client=client;
        this.properties=properties;
    }

    public void send(String telephone, String templateCode, Map<String, String> params) {
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(telephone);
        request.setTemplateCode(templateCode);
        request.setSignName(properties.getSmsSign());
        String paramString = JSONUtil.parse(params).toJSONString(0);
        request.setTemplateParam(paramString);
        try {
            SendSmsResponse response = client.sendSms(request);
            log.info("短信发送:{},{}", request, response);
        } catch (Exception e) {
            log.error("短信发送失败", e);
        }
    }
}
