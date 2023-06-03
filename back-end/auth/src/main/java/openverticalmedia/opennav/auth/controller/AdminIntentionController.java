package openverticalmedia.opennav.auth.controller;

import openverticalmedia.opennav.annotation.AdminController;
import openverticalmedia.opennav.auth.dto.JwtData;
import openverticalmedia.opennav.auth.dto.JwtDto;
import openverticalmedia.opennav.auth.service.AdminIntentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AdminController("admin/auth")
public class AdminIntentionController {
    @Autowired
    AdminIntentionService service;
    @PostMapping
    public JwtDto post(@RequestBody JwtData data){
        return service.post(data);
    }
}
