package openverticalmedia.opennav.nav.meta;

import lombok.Data;

/**
 * 媒体-元数据
 */
@Data
public class MediumMeta {
    /**
     * 图片地址
     */
    private String imgUrl;
    /**
     * 视频地址
     */
    private String videoUrl;
    /**
     * 链接地址
     */
    private String linkUrl;
}
