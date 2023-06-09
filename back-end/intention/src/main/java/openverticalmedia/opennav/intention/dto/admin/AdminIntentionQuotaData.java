package openverticalmedia.opennav.intention.dto.admin;

import lombok.Data;

@Data
public class AdminIntentionQuotaData {
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
     *
     */
    private long partnerId;
}
