package openverticalmedia.opennav.intention.controller.partner;

import openverticalmedia.opennav.common.annotation.PartnerController;
import openverticalmedia.opennav.common.model.PartnerModel;
import openverticalmedia.opennav.intention.dto.partner.PartnerIntentionRecordDto;
import openverticalmedia.opennav.intention.service.partner.PartnerIntentionRecordService;
import openverticalmedia.opennav.common.model.ManagerModel;
import openverticalmedia.opennav.common.model.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@PartnerController("partner/intention/record")
public class PartnerIntentionRecordController {
    @Autowired
    PartnerIntentionRecordService service;

    @GetMapping
    public Pager<PartnerIntentionRecordDto> query(@ModelAttribute("partnerModel") PartnerModel partner,
                                                  @RequestParam(required = false, defaultValue = "1") int page,
                                                  @RequestParam(required = false, defaultValue = "10") int size) {
        return service.query(partner,page, size);
    }
}