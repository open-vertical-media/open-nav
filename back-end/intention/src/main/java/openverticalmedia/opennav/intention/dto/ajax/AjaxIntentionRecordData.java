package openverticalmedia.opennav.intention.dto.ajax;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Data
public class AjaxIntentionRecordData {
    /**
     * 路径
     */
    @NotBlank
    private String path;
    /**
     * 名称
     */
    @NotBlank
    private String name;
    /**
     * 手机号
     */
    @NotBlank
    private String telephone;
    /**
     * 消息
     */
    @Max(value = 500,message = "文字不能超过500字")
    private String message;
}
