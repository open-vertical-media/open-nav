package openverticalmedia.opennav.advert.controller.ajax;

import openverticalmedia.opennav.advert.dto.ajax.AjaxAdvertScheduleData;
import openverticalmedia.opennav.advert.dto.ajax.AjaxAdvertScheduleDto;
import openverticalmedia.opennav.advert.service.ajax.AjaxAdvertScheduleService;
import openverticalmedia.opennav.common.annotation.AjaxController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@AjaxController("ajax/important")
public class AjaxAdvertScheduleController {
    @Autowired
    AjaxAdvertScheduleService service;
    @GetMapping
    public List<AjaxAdvertScheduleDto> important(AjaxAdvertScheduleData data){
        return service.get(data);
    }
}
