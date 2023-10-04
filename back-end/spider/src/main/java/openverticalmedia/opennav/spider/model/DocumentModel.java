package openverticalmedia.opennav.spider.model;

import lombok.Data;

import java.util.List;

@Data
public class DocumentModel {
    /**
     * 域名
     */
    private String domain;
    /**
     * 标题
     */
    private String title;
    /**
     * 关键词
     */
    private String keywords;
    /**
     * 描述
     */
    private String description;
    /**
     * 内容
     */
    private String body;
    /**
     * 链接集合
     */
    private List<LinkModel> sites;
    /**
     * 页面集合
     */
    private List<LinkModel> pages;
}
