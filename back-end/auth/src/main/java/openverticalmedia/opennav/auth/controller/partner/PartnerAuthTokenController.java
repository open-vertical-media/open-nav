package openverticalmedia.opennav.auth.controller.partner;

import openverticalmedia.opennav.auth.dto.TokenData;
import openverticalmedia.opennav.auth.dto.TokenDto;
import openverticalmedia.opennav.auth.service.PartnerAuthTokenService;
import openverticalmedia.opennav.common.annotation.PartnerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@PartnerController("partner/auth/token")
public class PartnerAuthTokenController {
    @Autowired
    PartnerAuthTokenService service;
    @PostMapping
    public TokenDto post(@RequestBody TokenData data){
        return service.post(data);
    }
}
