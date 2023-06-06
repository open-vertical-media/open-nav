package openverticalmedia.opennav.intention.controller.ajax;

import openverticalmedia.opennav.annotation.AjaxController;
import openverticalmedia.opennav.intention.dto.ajax.AjaxIntentionRecordData;
import openverticalmedia.opennav.intention.service.ajax.AjaxIntentionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AjaxController("ajax/intention/record")
public class AjaxIntentionRecordController {
    @Autowired
    AjaxIntentionRecordService service;
    @PostMapping
    public void post(@RequestBody AjaxIntentionRecordData data){
        service.post(data);
    }
}
