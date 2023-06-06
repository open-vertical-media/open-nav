package openverticalmedia.opennav.intention.controller.admin;

import openverticalmedia.opennav.annotation.AdminController;
import openverticalmedia.opennav.intention.dto.admin.AdminIntentionRecordDto;
import openverticalmedia.opennav.intention.service.admin.AdminIntentionRecordService;
import openverticalmedia.opennav.model.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@AdminController("admin/intention/record")
public class AdminIntentionRecordController {
    @Autowired
    AdminIntentionRecordService service;
    @GetMapping
    public Pager<AdminIntentionRecordDto> query(@RequestParam(required = false)Long partnerId,
                                                @RequestParam(required = false)String name,
                                                @RequestParam(required = false)String telephone){
        return service.query(partnerId,name,telephone);
    }
}
