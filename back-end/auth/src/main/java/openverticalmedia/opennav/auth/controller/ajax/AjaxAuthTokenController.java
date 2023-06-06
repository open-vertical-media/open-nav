package openverticalmedia.opennav.auth.controller.ajax;

import openverticalmedia.opennav.annotation.AjaxController;
import openverticalmedia.opennav.auth.dto.TokenData;
import openverticalmedia.opennav.auth.dto.TokenDto;
import openverticalmedia.opennav.auth.service.AjaxAuthTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AjaxController("ajax/auth")
public class AjaxAuthTokenController {
    @Autowired
    AjaxAuthTokenService service;
    @PostMapping
    public TokenDto post(@RequestBody TokenData data){
        return service.post(data);
    }
}
