package openverticalmedia.opennav.intention.controller.partner;

import openverticalmedia.opennav.common.annotation.PartnerController;
import openverticalmedia.opennav.common.model.PartnerModel;
import openverticalmedia.opennav.intention.dto.partner.PartnerIntentionRequestData;
import openverticalmedia.opennav.intention.dto.partner.PartnerIntentionRequestDto;
import openverticalmedia.opennav.intention.service.partner.PartnerIntentionRequestService;
import openverticalmedia.opennav.common.model.ManagerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@PartnerController("partner/intention/request")
public class PartnerIntentionRequestController {
    @Autowired
    PartnerIntentionRequestService service;

    @PostMapping
    public long post(@ModelAttribute("partnerModel") PartnerModel partner,
                     @RequestBody PartnerIntentionRequestData data) {
        return service.post(partner, data);
    }

    @GetMapping("{id}")
    public PartnerIntentionRequestDto get(@ModelAttribute("partnerModel") PartnerModel partner,@PathVariable long id) {
        return service.get(partner,id);
    }
}
