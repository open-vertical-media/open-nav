package openverticalmedia.opennav.file.controller.admin;

import openverticalmedia.opennav.common.annotation.AdminController;
import openverticalmedia.opennav.file.service.admin.AdminFileResourceService;
import openverticalmedia.opennav.sdk.resource.ResourceRequestModel;
import openverticalmedia.opennav.sdk.resource.ResourceResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

@AdminController("admin/file/resource")
public class AdminFileResourceController {
    @Autowired
    AdminFileResourceService service;
    public ResourceResponseModel auth(@RequestBody ResourceRequestModel request) {
        return service.auth(request);
    }
}
