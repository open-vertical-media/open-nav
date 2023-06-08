package openverticalmedia.opennav.auth.dto.admin;

import lombok.Data;
import openverticalmedia.opennav.auth.model.PowerModel;

import java.util.List;

@Data
public class AdminAuthAccountData {
    private String name;
    private String password;
    private List<PowerModel> powers;
}
