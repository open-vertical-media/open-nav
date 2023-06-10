package openverticalmedia.opennav.nav.convert;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import openverticalmedia.opennav.nav.meta.MediumMeta;

import javax.persistence.AttributeConverter;

public class MediumMetaConvert implements AttributeConverter<MediumMeta,String> {
    @Override
    public String convertToDatabaseColumn(MediumMeta contentMeta) {
        return JSONUtil.toJsonStr(contentMeta);
    }

    @Override
    public MediumMeta convertToEntityAttribute(String s) {
        if(StrUtil.isNotBlank(s)){
            return JSONUtil.toBean(s,MediumMeta.class);
        }
        return null;
    }
}
