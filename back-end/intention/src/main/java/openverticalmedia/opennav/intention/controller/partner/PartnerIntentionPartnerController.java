package openverticalmedia.opennav.intention.controller.partner;

import openverticalmedia.opennav.annotation.PartnerController;
import openverticalmedia.opennav.intention.dto.partner.PartnerIntentionPartnerDto;
import openverticalmedia.opennav.intention.service.partner.PartnerIntentionPartnerService;
import openverticalmedia.opennav.model.ManagerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@PartnerController("partner/intention/partner")
public class PartnerIntentionPartnerController {
    @Autowired
    PartnerIntentionPartnerService service;
    @GetMapping
    public PartnerIntentionPartnerDto get(@ModelAttribute("managerModel") ManagerModel manager) {
        return service.get(manager);
    }
}