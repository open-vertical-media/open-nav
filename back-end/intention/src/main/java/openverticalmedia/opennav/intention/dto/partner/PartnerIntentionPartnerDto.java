package openverticalmedia.opennav.intention.dto.partner;

import lombok.Data;

@Data
public class PartnerIntentionPartnerDto {
    private long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 剩余额度
     */
    private int quota;
}
