package openverticalmedia.opennav.config.controller.template;

import cn.hutool.json.JSONUtil;
import openverticalmedia.opennav.config.service.TemplateConfigPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TemplateConfigProperty {
    @Autowired
    TemplateConfigPropertyService service;
    public <T> T get(String key,Class<T> tClass) {
        String value = service.get(key);
        return JSONUtil.toBean(value, tClass);
    }
}