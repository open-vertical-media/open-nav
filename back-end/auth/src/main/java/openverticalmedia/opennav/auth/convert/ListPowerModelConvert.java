package openverticalmedia.opennav.auth.convert;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import openverticalmedia.opennav.auth.model.PowerModel;

import javax.persistence.AttributeConverter;
import java.util.List;

public class ListPowerModelConvert implements AttributeConverter<List<PowerModel>, String> {
    @Override
    public String convertToDatabaseColumn(List<PowerModel> powerModels) {
        return JSONUtil.toJsonStr(powerModels);
    }

    @Override
    public List<PowerModel> convertToEntityAttribute(String s) {
        if (StrUtil.isNotBlank(s)) {
            return JSONUtil.toBean(s, new TypeReference<List<PowerModel>>() {
            }, true);
        }
        return null;
    }
}