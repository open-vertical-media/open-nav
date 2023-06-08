package openverticalmedia.opennav.intention.controller.admin;

import openverticalmedia.opennav.common.annotation.AdminController;
import openverticalmedia.opennav.intention.dto.admin.AdminIntentionQuotaData;
import openverticalmedia.opennav.intention.dto.admin.AdminIntentionQuotaDto;
import openverticalmedia.opennav.intention.service.admin.AdminIntentionQuotaService;
import openverticalmedia.opennav.common.model.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@AdminController("admin/intention/quota")
public class AdminIntentionQuotaController {
    @Autowired
    AdminIntentionQuotaService service;

    @GetMapping
    public Pager<AdminIntentionQuotaDto> query(@RequestParam(required = false,defaultValue = "1")int page,
                                               @RequestParam(required = false,defaultValue = "10")int size){
        return service.query(page,size);
    }

    @GetMapping("{id}")
    public AdminIntentionQuotaDto get(@PathVariable long id){
        return service.get(id);
    }

    @PostMapping
    public long post(@RequestBody AdminIntentionQuotaData data){
        return service.post(data);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id){
        service.delete(id);
    }
}
