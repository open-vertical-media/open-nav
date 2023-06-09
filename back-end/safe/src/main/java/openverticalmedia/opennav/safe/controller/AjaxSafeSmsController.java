package openverticalmedia.opennav.safe.controller;

import openverticalmedia.opennav.common.annotation.AjaxController;
import openverticalmedia.opennav.safe.dto.AjaxSafeSmsData;
import openverticalmedia.opennav.safe.dto.AjaxSafeSmsDto;
import openverticalmedia.opennav.safe.service.AjaxSafeSmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AjaxController("ajax/safe/sms")
public class AjaxSafeSmsController {
    @Autowired
    AjaxSafeSmsService service;
    @PostMapping
    public AjaxSafeSmsDto sms(@RequestBody AjaxSafeSmsData data){
        return service.sms(data);
    }
}
