package openverticalmedia.opennav.sdk.code;

import com.aliyuncs.IAcsClient;
import com.aliyuncs.afs.model.v20180112.AnalyzeNvcRequest;
import com.aliyuncs.afs.model.v20180112.AnalyzeNvcResponse;
import com.aliyuncs.exceptions.ClientException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CodeTemplate {
    final IAcsClient client;
    public CodeTemplate(IAcsClient client){
        this.client=client;
    }

    public String check(String data) {
        return "200";
//        AnalyzeNvcRequest request = new AnalyzeNvcRequest();
//        request.setData(data);
//        request.setScoreJsonStr("{\"200\":\"PASS\",\"400\":\"NC\",\"800\":\"BLOCK\"}");
//        try {
//            AnalyzeNvcResponse response = client.getAcsResponse(request);
//            return  response.getBizCode();
//        } catch (ClientException e) {
//            log.error("验证失败", e);
//            return "500";
//        }
    }
}
