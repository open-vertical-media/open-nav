package openverticalmedia.opennav.intention.controller.admin;

import openverticalmedia.opennav.annotation.AdminController;
import openverticalmedia.opennav.intention.dto.admin.AdminIntentionPlantData;
import openverticalmedia.opennav.intention.dto.admin.AdminIntentionPlantDto;
import openverticalmedia.opennav.intention.service.admin.AdminIntentionPlantService;
import openverticalmedia.opennav.model.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@AdminController("admin/intention/plant")
public class AdminIntentionPlantController {
    @Autowired
    AdminIntentionPlantService service;
    @GetMapping
    public Pager<AdminIntentionPlantDto> query(@RequestParam(required = false,defaultValue = "1")int page,
                                               @RequestParam(required = false,defaultValue = "10")int size){
        return service.query(page,size);
    }
    @GetMapping("{id}")
    public AdminIntentionPlantDto get(@PathVariable long id){
        return service.get(id);
    }
    @PostMapping
    public long post(@RequestBody AdminIntentionPlantData data){
        return service.post(data);
    }
    @PutMapping("{id}")
    public boolean put(@PathVariable long id,@RequestBody AdminIntentionPlantData data){
        return service.put(id,data);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable long id){
        service.delete(id);
    }
}
