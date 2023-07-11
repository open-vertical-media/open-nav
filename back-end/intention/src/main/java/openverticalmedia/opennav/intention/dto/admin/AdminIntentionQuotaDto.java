package openverticalmedia.opennav.intention.dto.admin;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class AdminIntentionQuotaDto {
    private long id;
    /**
     * 类型
     * 充值/扣减
     */
    private String type;
    /**
     * 数量
     */
    private int number;
    /**
     * 合作伙伴ID
     */
    private long partnerId;
    /**
     * 合作伙伴名称
     */
    private String partnerName;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private Timestamp time;

}
