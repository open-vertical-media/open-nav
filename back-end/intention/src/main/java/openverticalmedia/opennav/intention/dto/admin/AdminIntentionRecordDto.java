package openverticalmedia.opennav.intention.dto.admin;

import lombok.Data;

@Data
public class AdminIntentionRecordDto {
    /**
     * 名称
     */
    private String name;
    /**
     * 路径
     */
    private String path;
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
