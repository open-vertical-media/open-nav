package openverticalmedia.opennav.auth.dto.admin;

import lombok.Data;
import openverticalmedia.opennav.auth.model.PowerModel;

import java.util.List;

@Data
public class AdminAuthAccountDto {
    private long id;
    private String name;
    private String password;
    private List<PowerModel> powers;
}
