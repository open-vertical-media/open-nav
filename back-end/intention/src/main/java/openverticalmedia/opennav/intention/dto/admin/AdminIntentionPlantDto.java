package openverticalmedia.opennav.intention.dto.admin;

import lombok.Data;

@Data
public class AdminIntentionPlantDto {
    private long id;
    /**
     * 路径
     */
    private String path;
    /**
     *
     */
    private long partnerId;
}
