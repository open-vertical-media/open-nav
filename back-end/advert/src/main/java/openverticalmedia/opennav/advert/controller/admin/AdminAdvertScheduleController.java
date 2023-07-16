package openverticalmedia.opennav.advert.controller.admin;

import openverticalmedia.opennav.advert.dto.admin.AdminAdvertScheduleDto;
import openverticalmedia.opennav.advert.service.admin.AdminAdvertScheduleService;
import openverticalmedia.opennav.common.annotation.AdminController;
import openverticalmedia.opennav.common.model.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@AdminController("admin/advert/schedule")
public class AdminAdvertScheduleController {
    @Autowired
    AdminAdvertScheduleService service;

    @GetMapping
    public Pager<AdminAdvertScheduleDto> query(@RequestParam(required = false, defaultValue = "10") int size,
                                               @RequestParam(required = false, defaultValue = "1") int page) {
        return service.query(page,size);
    }
    @GetMapping("{id}")
    public AdminAdvertScheduleDto get(@PathVariable long id){
        return service.get(id);
    }
    @PostMapping
    public long post(@RequestBody AdminAdvertScheduleDto data){
        return service.post(data);
    }
    @PutMapping("{id}")
    public boolean put(@PathVariable long id,@RequestBody AdminAdvertScheduleDto data){
        return service.put(id,data);
    }
}