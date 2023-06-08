package openverticalmedia.opennav.intention.controller.partner;

import openverticalmedia.opennav.common.annotation.PartnerController;
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
    public long post(@ModelAttribute("managerModel") ManagerModel manager,
                     @RequestBody PartnerIntentionRequestData data) {
        return service.post(manager, data);
    }

    @GetMapping("{id}")
    public PartnerIntentionRequestDto get(@PathVariable long id) {
        return service.get(id);
    }
}
