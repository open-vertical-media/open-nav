package openverticalmedia.opennav.nav.convert;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import openverticalmedia.opennav.nav.meta.ContentMeta;

import javax.persistence.AttributeConverter;

public class ContentMetaConvert implements AttributeConverter<ContentMeta,String> {
    @Override
    public String convertToDatabaseColumn(ContentMeta contentMeta) {
        return JSONUtil.toJsonStr(contentMeta);
    }

    @Override
    public ContentMeta convertToEntityAttribute(String s) {
        if(StrUtil.isNotBlank(s)){
            return JSONUtil.toBean(s,ContentMeta.class);
        }
        return null;
    }
}
