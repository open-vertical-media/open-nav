package openverticalmedia.opennav.file.service.admin;

import openverticalmedia.opennav.sdk.resource.ResourceRequestModel;
import openverticalmedia.opennav.sdk.resource.ResourceResponseModel;
import openverticalmedia.opennav.sdk.resource.ResourceTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminFileResourceService {
    @Autowired
    ResourceTemplate template;
    public ResourceResponseModel auth(ResourceRequestModel request) {
        //TODO SCENE选定策略
        return template.auth(request);
    }
}
