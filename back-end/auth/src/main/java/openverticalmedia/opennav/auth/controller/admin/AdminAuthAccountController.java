package openverticalmedia.opennav.auth.controller.admin;


import openverticalmedia.opennav.common.annotation.AdminController;
import openverticalmedia.opennav.auth.dto.admin.AdminAuthAccountDto;
import openverticalmedia.opennav.auth.service.admin.AdminAuthAccountService;
import openverticalmedia.opennav.auth.dto.admin.AdminAuthAccountData;
import openverticalmedia.opennav.common.model.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@AdminController("admin/auth/account")
public class AdminAuthAccountController {
    @Autowired
    AdminAuthAccountService service;
    @GetMapping
    public Pager<AdminAuthAccountDto> query(@RequestParam(required = false)String name,
                                            @RequestParam(required = false,defaultValue = "1")int page,
                                            @RequestParam(required = false,defaultValue = "10")int size){
        return service.query(name,page,size);
    }
    @GetMapping("{id}")
    public AdminAuthAccountDto get(@PathVariable long id){
        return service.get(id);
    }
    @PostMapping
    public long post(@RequestBody AdminAuthAccountData data){
        return service.post(data);
    }
    @PutMapping("{id}")
    public boolean put(@PathVariable long id,@RequestBody AdminAuthAccountData data){
        return service.put(id,data);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable long id){
        service.delete(id);
    }
}
