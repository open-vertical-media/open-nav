package openverticalmedia.opennav.intention.controller.admin;

import openverticalmedia.opennav.common.annotation.AdminController;
import openverticalmedia.opennav.intention.dto.admin.AdminIntentionPartnerData;
import openverticalmedia.opennav.intention.dto.admin.AdminIntentionPartnerDto;
import openverticalmedia.opennav.intention.service.admin.AdminIntentionPartnerService;
import openverticalmedia.opennav.common.model.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@AdminController("admin/intention/partner")
public class AdminIntentionPartnerController {
    @Autowired
    AdminIntentionPartnerService service;

    @GetMapping
    public Pager<AdminIntentionPartnerDto> query(@RequestParam(required = false) String name,
                                                 @RequestParam(required = false, defaultValue = "10") int size,
                                                 @RequestParam(required = false, defaultValue = "1") int page) {
        return service.query(name, size, page);
    }
    @GetMapping("{id}")
    public AdminIntentionPartnerDto get(@PathVariable long id){
        return service.get(id);
    }

    @PostMapping
    public long post(@RequestBody AdminIntentionPartnerData data) {
        return service.post(data);
    }

    @PutMapping("{id}")
    public boolean put(@PathVariable long id, @RequestBody AdminIntentionPartnerData data) {
        return service.put(id, data);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}