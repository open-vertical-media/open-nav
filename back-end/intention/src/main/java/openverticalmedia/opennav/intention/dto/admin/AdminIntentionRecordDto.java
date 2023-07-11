package openverticalmedia.opennav.intention.dto.admin;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

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
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private Timestamp time;
    /**
     * 备注
     */
    private String remark;
}
