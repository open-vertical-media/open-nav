package openverticalmedia.opennav.intention.controller.admin;

import openverticalmedia.opennav.annotation.AdminController;
import openverticalmedia.opennav.intention.dto.admin.IntentionPlantData;
import openverticalmedia.opennav.intention.dto.admin.IntentionPlantDto;
import openverticalmedia.opennav.intention.service.admin.IntentionPlantAdminService;
import openverticalmedia.opennav.model.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@AdminController("admin/intention/plant")
public class AdminIntentionPlantController {
    @Autowired
    IntentionPlantAdminService service;
    @GetMapping
    public Pager<IntentionPlantDto> query(@RequestParam(required = false,defaultValue = "1")int page,
                                          @RequestParam(required = false,defaultValue = "10")int size){
        return service.query(page,size);
    }
    @GetMapping("{id}")
    public IntentionPlantDto get(@PathVariable long id){
        return service.get(id);
    }
    @PostMapping
    public long post(@RequestBody IntentionPlantData data){
        return service.post(data);
    }
    @PutMapping("{id}")
    public boolean put(@PathVariable long id,@RequestBody IntentionPlantData data){
        return service.put(id,data);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable long id){
        service.delete(id);
    }
}
