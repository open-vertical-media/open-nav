package openverticalmedia.opennav.spider.manager;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.json.JSONUtil;
import openverticalmedia.opennav.sdk.task.TaskModel;
import openverticalmedia.opennav.sdk.task.TaskTemplate;
import openverticalmedia.opennav.spider.entity.SpiderSiteEntity;
import openverticalmedia.opennav.spider.model.SpiderTaskModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpiderHandler {
    @Autowired
    TaskTemplate taskTemplate;
    public void save(SpiderSiteEntity entity){
        TaskModel taskModel=new TaskModel();
        taskModel.setName("spiderTaskController");
        SpiderTaskModel spiderTaskModel=new SpiderTaskModel();
        spiderTaskModel.setId(entity.getId());
        spiderTaskModel.setUrl(entity.getDomain());
        spiderTaskModel.setType("Site");
        taskModel.setParam(JSONUtil.toJsonStr(spiderTaskModel));
        taskTemplate.add(taskModel);
    }
}
