package openverticalmedia.opennav.nav.convert;

import cn.hutool.core.util.StrUtil;

import javax.persistence.AttributeConverter;
import java.util.List;

public class ListStringConvert implements AttributeConverter<List<String>,String> {
    @Override
    public String convertToDatabaseColumn(List<String> strings) {
        return StrUtil.join(",",strings);
    }

    @Override
    public List<String> convertToEntityAttribute(String s) {
        return StrUtil.split(s,',');
    }
}
