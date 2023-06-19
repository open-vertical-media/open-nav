package openverticalmedia.opennav.intention.dto.admin;

import lombok.Data;

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

}
