package openverticalmedia.opennav.intention.dto.partner;

import lombok.Data;

@Data
public class PartnerIntentionRequestDto {
    private long id;
    /**
     * 合作伙伴ID
     */
    private long partnerId;
    /**
     * 关联类型
     */
    private String relationType;
    /***
     * 关联ID
     */
    private long relationId;
}
