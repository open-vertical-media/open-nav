package openverticalmedia.opennav.spider.model;

import lombok.Data;

@Data
public class SpiderTaskModel {
    /**
     * 类型
     * Site / Page
     */
    private String type;
    /**
     * ID
     */
    private long id;
    /**
     * 地址
     */
    private String url;
}
