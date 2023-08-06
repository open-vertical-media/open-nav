package openverticalmedia.opennav.sdk.resource;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;

import java.util.List;
import java.util.stream.Collectors;

public class ResourceTemplate {
    private final OSSClient ossClient;
    private final ResourceProperties properties;
    public ResourceTemplate(OSSClient ossClient,ResourceProperties properties){
        this.ossClient=ossClient;
        this.properties=properties;
    }

    public ResourceResponseModel auth(ResourceRequestModel request) {
        if (!properties.getScenes().containsKey(request.getScene())) {
            return null;
        }
        ResourceResponseModel result=new ResourceResponseModel();
        ResourceScene resourceScene = properties.getScenes().get(request.getScene());
        List<String> contentTypes = properties.getContentTypes().entrySet()
                .stream()
                .flatMap(c -> c.getValue().stream())
                .collect(Collectors.toList());

        PolicyConditions policy = new PolicyConditions();
        policy.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, resourceScene.getFileSize());
        policy.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, filePath);
        if (!"*".equals(resourceScene.getAllowType())) {
            List<String> contentTypes= StrUtil.split(resourceScene.getAllowType(),','
            policy.addConditionItem(MatchMode.In, PolicyConditions.COND_CONTENT_TYPE, JSONUtil.toJsonStr(contentTypes));
        }
        return result;
    }
}
