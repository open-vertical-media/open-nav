package openverticalmedia.opennav.sdk.resource;

import lombok.Data;

@Data
public class ResourceResponseModel {
    private String accessId;
    private String policy;
    private String signature;
    private String key;
    private String host;
    private String expire;
    private String fileName;
}
