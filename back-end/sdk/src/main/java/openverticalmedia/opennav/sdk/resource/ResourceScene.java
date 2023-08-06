package openverticalmedia.opennav.sdk.resource;

import lombok.Data;

@Data
public class ResourceScene {
    /**
     * 允许扩展名,如:,.zip,.rar,.pdf,
     */
    private String allowExtension;
    /**
     * 允许Content-Type,如 image/png,image/jpeg
     */
    private String allowType;

    /**
     * 允许文件大小(字节 1024*1024*10  => 10M) 0 表示不限制
     */
    private int fileSize;


    /**
     * 时间格式目录
     */
    private String timeFormat;

    /**
     * 保存目录格式
     */
    private String directoryFormat;
}
