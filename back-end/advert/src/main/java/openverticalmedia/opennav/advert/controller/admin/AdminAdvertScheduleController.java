package openverticalmedia.opennav.advert.controller.admin;

import openverticalmedia.opennav.advert.dto.admin.AdminAdvertScheduleDto;
import openverticalmedia.opennav.advert.service.admin.AdminAdvertScheduleService;
import openverticalmedia.opennav.common.annotation.AdminController;
import openverticalmedia.opennav.common.model.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

@AdminController("admin/advert/schedule")
public class AdminAdvertScheduleController {
    @Autowired
    AdminAdvertScheduleService service;

    public Pager<AdminAdvertScheduleDto> query(@RequestParam(required = false, defaultValue = "10") int size,
                                               @RequestParam(required = false, defaultValue = "1") int page) {
        return service.query(page,size);
    }
}