package openverticalmedia.opennav.nav.convert;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import openverticalmedia.opennav.nav.model.TemplateItem;

import javax.persistence.AttributeConverter;
import java.util.List;

public class ListTemplateItemConvert implements AttributeConverter<List<TemplateItem>, String> {
    @Override
    public String convertToDatabaseColumn(List<TemplateItem> powerModels) {
        return JSONUtil.toJsonStr(powerModels);
    }

    @Override
    public List<TemplateItem> convertToEntityAttribute(String s) {
        if (StrUtil.isNotBlank(s)) {
            return JSONUtil.toBean(s, new TypeReference<List<TemplateItem>>() {
            }, true);
        }
        return null;
    }
}