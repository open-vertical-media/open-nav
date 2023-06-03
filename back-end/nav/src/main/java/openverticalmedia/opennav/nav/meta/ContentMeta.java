package openverticalmedia.opennav.nav.meta;


import lombok.Data;

/**
 * 内容元数据
 */
@Data
public class ContentMeta {
    /**
     * 标题
     */
    private String title;
    /**
     * 副标题
     */
    private String subTitle;
    /**
     * 描述简介
     */
    private String description;
    /**
     * 主体内容
     */
    private String content;
}
