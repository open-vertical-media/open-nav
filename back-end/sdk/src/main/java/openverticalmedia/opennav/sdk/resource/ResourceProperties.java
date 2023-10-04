package openverticalmedia.opennav.sdk.resource;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ResourceProperties {
    /**
     * endpoint 内网
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
     * BUCKET域名
     */
    private String bucket;
    /**
     * 应用场景
     */
    private Map<String,ResourceScene> scenes;
}
