package openverticalmedia.opennav.sdk.resource;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import openverticalmedia.opennav.common.exception.LogicException;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;

public class ResourceTemplate {
    private final OSSClient ossClient;
    private final ResourceProperties properties;

    public ResourceTemplate(OSSClient ossClient, ResourceProperties properties) {
        this.ossClient = ossClient;
        this.properties = properties;
    }

    public ResourceResponseModel auth(ResourceRequestModel request) {
        if (!properties.getScenes().containsKey(request.getScene())) {
            throw new LogicException("找不到对应的上传配置:" + request.getScene());
        }
        ResourceScene resourceScene = properties.getScenes().get(request.getScene());
        int fileSize = resourceScene.getFileSize();
        List<String> allowExtensions = resourceScene.getAllowExtensions();
        List<String> allowTypes = resourceScene.getAllowTypes();
        String directory = resourceScene.getDirectory();
        int expire=resourceScene.getExpire();

        if (request.getFileSize() > fileSize) {
            throw new LogicException("上传的文件过大:" + request.getFileSize() + ",应该小于:" + fileSize);
        }
        String extName = FileUtil.extName(request.getFileName());
        if(CollUtil.isNotEmpty(allowExtensions)) {
            if (allowExtensions.stream()
                    .noneMatch(e -> e.endsWith(extName))) {
                throw new LogicException("不支持该类型文件:" + extName + ",仅支持:" + StrUtil.join(",", allowExtensions));
            }
        }
        ResourceResponseModel result = new ResourceResponseModel();
        PolicyConditions policy = new PolicyConditions();
        if (CollUtil.isNotEmpty(allowTypes)) {
            policy.addConditionItem(MatchMode.In, PolicyConditions.COND_CONTENT_TYPE, ArrayUtil.toArray(allowTypes,String.class));
        }
        policy.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, fileSize);
        String filePath = directory + request.getFileName();
        policy.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, filePath);

        Date expiration=new Date(System.currentTimeMillis()+expire*1000L);
        String postPolicy = ossClient.generatePostPolicy(expiration, policy);
        byte[] binaryData = postPolicy.getBytes(Charset.defaultCharset());
        String encodePolicy = BinaryUtil.toBase64String(binaryData);

        String postSignature = ossClient.calculatePostSignature(postPolicy);
        result.setAccessId(properties.getAccessKeyId());
        result.setPolicy(encodePolicy);
        result.setSignature(postSignature);
        result.setKey(filePath);
        result.setEndpoint(properties.getBucket());
        result.setExpire(expire);
        return result;
    }
}