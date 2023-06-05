package openverticalmedia.opennav.intention.controller.admin;

import openverticalmedia.opennav.annotation.AdminController;
import openverticalmedia.opennav.intention.dto.admin.IntentionQuotaData;
import openverticalmedia.opennav.intention.dto.admin.IntentionQuotaDto;
import openverticalmedia.opennav.intention.service.admin.IntentionQuotaAdminService;
import openverticalmedia.opennav.model.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@AdminController("admin/intention/quota")
public class AdminIntentionQuotaController {
    @Autowired
    IntentionQuotaAdminService service;
    @GetMapping
    public Pager<IntentionQuotaDto> query(@RequestParam(required = false,defaultValue = "1")int page,
                                          @RequestParam(required = false,defaultValue = "10")int size){
        return service.query(page,size);
    }
    @GetMapping("{id}")
    public IntentionQuotaDto get(@PathVariable long id){
        return service.get(id);
    }
    @PostMapping
    public long post(@RequestBody IntentionQuotaData data){
        return service.post(data);
    }
    @PutMapping("{id}")
    public boolean put(@PathVariable long id,@RequestBody IntentionQuotaData data){
        return service.put(id,data);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable long id){
        service.delete(id);
    }
}
