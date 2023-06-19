package openverticalmedia.opennav.intention.controller.partner;

import openverticalmedia.opennav.common.annotation.PartnerController;
import openverticalmedia.opennav.common.model.PartnerModel;
import openverticalmedia.opennav.intention.dto.partner.PartnerIntentionPartnerDto;
import openverticalmedia.opennav.intention.service.partner.PartnerIntentionPartnerService;
import openverticalmedia.opennav.common.model.ManagerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@PartnerController("partner/intention/partner")
public class PartnerIntentionPartnerController {
    @Autowired
    PartnerIntentionPartnerService service;
    @GetMapping
    public PartnerIntentionPartnerDto get(@ModelAttribute("partnerModel") PartnerModel partner) {
        return service.get(partner);
    }
}