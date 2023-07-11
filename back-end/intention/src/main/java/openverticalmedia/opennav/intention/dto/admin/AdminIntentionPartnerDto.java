package openverticalmedia.opennav.intention.dto.admin;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class AdminIntentionPartnerDto {
    private long id;
    private String name;
    private String telephone;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private Timestamp time;
}
