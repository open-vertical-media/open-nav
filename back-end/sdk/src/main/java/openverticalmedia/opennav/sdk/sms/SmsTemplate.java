package openverticalmedia.opennav.sdk.sms;

import cn.hutool.json.JSONUtil;
import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import lombok.extern.slf4j.Slf4j;
import openverticalmedia.opennav.sdk.config.SdkSmsProperties;

import java.util.Map;

@Slf4j
public class SmsTemplate {
    final Client client;
    final SdkSmsProperties properties;
    public SmsTemplate(Client client,SdkSmsProperties properties){
        this.client=client;
        this.properties=properties;
    }

    public void send(String telephone, String templateCode, Map<String, String> params) {
        String paramString = JSONUtil.parse(params).toJSONString(0);
        SendSmsRequest request = new SendSmsRequest()
                .setPhoneNumbers(telephone)
                .setSignName(properties.getSmsSign())
                .setTemplateCode(templateCode)
                .setTemplateParam(paramString);
        try {
            SendSmsResponse response = client.sendSms(request);
            log.info("短信发送:{},{}", request, response);
        } catch (Exception e) {
            log.error("短信发送失败", e);
        }
    }
}
