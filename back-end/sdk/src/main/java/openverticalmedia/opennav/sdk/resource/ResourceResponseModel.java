package openverticalmedia.opennav.sdk.resource;

import lombok.Data;

@Data
public class ResourceResponseModel {
    private String endpoint;
    private String accessId;
    private String key;
    private int expire;
    private String fileName;
    private String policy;
    private String signature;
}
