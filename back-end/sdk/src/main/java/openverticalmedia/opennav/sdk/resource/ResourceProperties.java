package openverticalmedia.opennav.sdk.resource;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ResourceProperties {
    /**
     * endpoint 外网
     */
    private String endpoint;
    /**
     * accessKeyId
     */
    private String accessKeyId;
    /**
     * accessKeySecret
     */
    private String accessKeySecret;
    /**
     * BUCKET_NAME
     */
    private String bucketName;
    /**
     * 域名
     */
    private String domain;
    /**
     * 区域id
     */
    private String regionId;
    /**
     * 应用场景
     */
    private Map<String,ResourceScene> scenes;
}
