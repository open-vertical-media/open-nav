package openverticalmedia.opennav.sdk.resource;

import lombok.Data;

@Data
public class ResourceRequestModel {
    /**
     * 资源标识
     */
    private String scene;
    /**
     * 文件名
     */
    private String fileName;
    /**
     * 文件大小(单位:字节)
     */
    private long fileSize;
}
