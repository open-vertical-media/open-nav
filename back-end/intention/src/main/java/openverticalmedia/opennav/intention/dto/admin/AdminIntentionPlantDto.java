package openverticalmedia.opennav.intention.dto.admin;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

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
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private Timestamp time;
}
