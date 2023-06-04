package openverticalmedia.opennav.intention.controller;

import openverticalmedia.opennav.annotation.AjaxController;
import openverticalmedia.opennav.intention.dto.IntentionData;
import openverticalmedia.opennav.intention.service.IntentionAjaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AjaxController("ajax/intention")
public class AjaxIntentionController {
    @Autowired
    IntentionAjaxService service;
    @PostMapping
    public void post(@RequestBody IntentionData data){
        service.post(data);
    }
}
