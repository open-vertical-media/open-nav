package openverticalmedia.opennav.auth.controller.admin;

import openverticalmedia.opennav.annotation.AdminController;
import openverticalmedia.opennav.auth.dto.TokenData;
import openverticalmedia.opennav.auth.dto.TokenDto;
import openverticalmedia.opennav.auth.service.AdminAuthTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AdminController("admin/auth/token")
public class AdminAuthTokenController {
    @Autowired
    AdminAuthTokenService service;
    @PostMapping
    public TokenDto post(@RequestBody TokenData data){
        return service.post(data);
    }
}
