package openverticalmedia.opennav.config.controller.admin;

import openverticalmedia.opennav.common.annotation.AdminController;
import openverticalmedia.opennav.common.model.Pager;
import openverticalmedia.opennav.config.dto.AdminConfigPropertyDto;
import openverticalmedia.opennav.config.service.AdminConfigPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@AdminController("admin/config/property")
public class AdminConfigPropertyController {
    @Autowired
    AdminConfigPropertyService service;
    @GetMapping
    public Pager<AdminConfigPropertyDto> get(@RequestParam(defaultValue = "1")int page,
                                             @RequestParam(defaultValue = "20")int size){
        return service.get(page,size);
    }
}
