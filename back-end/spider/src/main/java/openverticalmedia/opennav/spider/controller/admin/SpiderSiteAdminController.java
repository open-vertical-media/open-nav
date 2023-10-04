package openverticalmedia.opennav.spider.controller.admin;

import openverticalmedia.opennav.common.annotation.AdminController;
import openverticalmedia.opennav.spider.dto.SpiderSiteData;
import openverticalmedia.opennav.spider.service.SpiderAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AdminController("admin/spider/site")
public class SpiderSiteAdminController {
    @Autowired
    SpiderAdminService service;

    @PostMapping
    public Long post(@Validated @RequestBody SpiderSiteData data) {
        return service.post(data);
    }
}