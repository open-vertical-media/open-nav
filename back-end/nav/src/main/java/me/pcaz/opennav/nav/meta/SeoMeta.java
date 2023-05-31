package me.pcaz.opennav.nav.meta;

import lombok.Data;

/**
 * SEO元数据
 */
@Data
public class SeoMeta {
    /**
     * 标题
     */
    private String title;
    /**
     * 描述
     */
    private String description;
    /**
     * 关键词
     */
    private String keywords;
}
