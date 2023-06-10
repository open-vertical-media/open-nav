package openverticalmedia.opennav.nav.convert;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import openverticalmedia.opennav.nav.meta.SeoMeta;

import javax.persistence.AttributeConverter;

public class SeoMetaConvert implements AttributeConverter<SeoMeta,String> {
    @Override
    public String convertToDatabaseColumn(SeoMeta contentMeta) {
        return JSONUtil.toJsonStr(contentMeta);
    }

    @Override
    public SeoMeta convertToEntityAttribute(String s) {
        if(StrUtil.isNotBlank(s)){
            return JSONUtil.toBean(s,SeoMeta.class);
        }
        return null;
    }
}
