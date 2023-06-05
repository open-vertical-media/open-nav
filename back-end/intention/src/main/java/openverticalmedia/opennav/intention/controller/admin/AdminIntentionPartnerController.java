package openverticalmedia.opennav.intention.controller.admin;

import openverticalmedia.opennav.annotation.AdminController;
import openverticalmedia.opennav.intention.dto.admin.IntentionPartnerData;
import openverticalmedia.opennav.intention.dto.admin.IntentionPartnerDto;
import openverticalmedia.opennav.intention.service.admin.IntentionPartnerAdminService;
import openverticalmedia.opennav.model.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@AdminController("admin/intention/partner")
public class AdminIntentionPartnerController {
    @Autowired
    IntentionPartnerAdminService service;

    @GetMapping
    public Pager<IntentionPartnerDto> query(@RequestParam(required = false, defaultValue = "null") String name,
                                            @RequestParam(required = false, defaultValue = "10") int size,
                                            @RequestParam(required = false, defaultValue = "1") int page) {
        return service.query(name, size, page);
    }
    @GetMapping("{id}")
    public IntentionPartnerDto get(@PathVariable long id){
        return service.get(id);
    }

    @PostMapping
    public long post(@RequestBody IntentionPartnerData data) {
        return service.post(data);
    }

    @PutMapping("{id}")
    public boolean put(@PathVariable long id, @RequestBody IntentionPartnerData data) {
        return service.put(id, data);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}