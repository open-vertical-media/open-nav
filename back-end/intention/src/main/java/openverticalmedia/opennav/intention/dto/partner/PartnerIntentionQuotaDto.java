package openverticalmedia.opennav.intention.dto.partner;

import lombok.Data;
import lombok.Getter;

@Data
public class PartnerIntentionQuotaDto {
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
    /**
     *
     */
    private long recordId;
}
