package me.pcaz.opennav.nav.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class TemplateItem {
    /**
     * 组件
     */
    private String component;
    /**
     * 数据源
     */
    private String datasource;
    /**
     * 插槽集合
     *
     */
    private List<String> slotNames;
    /**
     * 子组件集合
     */
    private Map<String,TemplateItem> subComponents;
}
