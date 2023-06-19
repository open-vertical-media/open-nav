package openverticalmedia.opennav.intention.controller.partner;

import openverticalmedia.opennav.common.annotation.PartnerController;
import openverticalmedia.opennav.common.model.PartnerModel;
import openverticalmedia.opennav.intention.dto.partner.PartnerIntentionQuotaDto;
import openverticalmedia.opennav.intention.service.partner.PartnerIntentionQuotaService;
import openverticalmedia.opennav.common.model.ManagerModel;
import openverticalmedia.opennav.common.model.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@PartnerController("partner/intention/quota")
public class PartnerIntentionQuotaController {
    @Autowired
    PartnerIntentionQuotaService service;
    @GetMapping
    public Pager<PartnerIntentionQuotaDto> query(@ModelAttribute("partnerModel") PartnerModel partner,
                                                 @RequestParam(required = false)String type,
                                                 @RequestParam(required = false,defaultValue = "1")int page,
                                                 @RequestParam(required = false,defaultValue = "10")int size){
        return service.query(partner,type,page,size);
    }
}
