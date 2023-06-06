package openverticalmedia.opennav.intention.controller.partner;

import openverticalmedia.opennav.annotation.PartnerController;
import openverticalmedia.opennav.intention.dto.partner.PartnerIntentionRequestData;
import openverticalmedia.opennav.intention.service.partner.PartnerIntentionRequestService;
import openverticalmedia.opennav.model.ManagerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@PartnerController("partner/intention/request")
public class PartnerIntentionRequestController {
    @Autowired
    PartnerIntentionRequestService service;
    @PostMapping
    public long post(@ModelAttribute("managerModel") ManagerModel manager,
                     @RequestBody PartnerIntentionRequestData data){
        return service.post(manager,data);
    }
}
