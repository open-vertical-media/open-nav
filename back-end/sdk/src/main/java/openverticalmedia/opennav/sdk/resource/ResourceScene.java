package openverticalmedia.opennav.sdk.resource;

import lombok.Data;

import java.util.List;

@Data
public class ResourceScene {
    /**
     * 允许扩展名,如:,.zip,.rar,.pdf,
     */
    private List<String> allowExtensions;
    /**
     * 允许Content-Type,如 image/png,image/jpeg
     */
    private List<String> allowTypes;
    /**
     * 允许文件大小(字节 1024*1024*10  => 10M) 0 表示不限制
     */
    private int fileSize;
    /**
     * 保存目录
     */
    private String directory;
    /**
     * 过期时长
     * 单位秒
     */
    private int expire;
}
