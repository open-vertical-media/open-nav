package openverticalmedia.opennav.intention.dto.partner;

import lombok.Data;

@Data
public class PartnerIntentionRecordDto {
    /**
     * 路径
     */
    private String path;
    /**
     * 名称
     */
    private String name;
    /**
     * 手机号
     */
    private String telephone;
    /**
     * 消息
     */
    private String message;
    /**
     * 状态
     */
    private String status;
}
