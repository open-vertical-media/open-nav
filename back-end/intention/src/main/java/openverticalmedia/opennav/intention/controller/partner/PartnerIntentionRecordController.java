package openverticalmedia.opennav.intention.controller.partner;

import openverticalmedia.opennav.annotation.PartnerController;
import openverticalmedia.opennav.intention.dto.partner.PartnerIntentionRecordDto;
import openverticalmedia.opennav.intention.service.partner.PartnerIntentionRecordService;
import openverticalmedia.opennav.model.ManagerModel;
import openverticalmedia.opennav.model.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@PartnerController("partner/intention/record")
public class PartnerIntentionRecordController {
    @Autowired
    PartnerIntentionRecordService service;

    @GetMapping
    public Pager<PartnerIntentionRecordDto> query(@ModelAttribute("managerModel") ManagerModel manager,
                                                  @RequestParam(required = false, defaultValue = "1") int page,
                                                  @RequestParam(required = false, defaultValue = "10") int size) {
        return service.query(manager,page, size);
    }
}