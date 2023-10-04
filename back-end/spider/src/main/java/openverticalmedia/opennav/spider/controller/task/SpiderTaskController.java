package openverticalmedia.opennav.spider.controller.task;

import cn.hutool.json.JSONUtil;
import openverticalmedia.opennav.sdk.task.ImmediatelyInterface;
import openverticalmedia.opennav.sdk.task.TaskModel;
import openverticalmedia.opennav.sdk.task.TaskTemplate;
import openverticalmedia.opennav.spider.entity.SpiderLinkEntity;
import openverticalmedia.opennav.spider.entity.SpiderPageEntity;
import openverticalmedia.opennav.spider.entity.SpiderSiteEntity;
import openverticalmedia.opennav.spider.manager.SpiderManager;
import openverticalmedia.opennav.spider.mapper.SiteMapper;
import openverticalmedia.opennav.spider.model.DocumentModel;
import openverticalmedia.opennav.spider.model.LinkModel;
import openverticalmedia.opennav.spider.model.SpiderTaskModel;
import openverticalmedia.opennav.spider.repository.SpiderLinkRepository;
import openverticalmedia.opennav.spider.repository.SpiderPageRepository;
import openverticalmedia.opennav.spider.repository.SpiderSiteRepository;
import openverticalmedia.opennav.spider.service.SpiderTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SpiderTaskController implements ImmediatelyInterface {
    @Autowired
    SpiderTaskService service;

    @Override
    public void run(String param) {
        service.run(param);
    }

    @Override
    public String name() {
        return "spiderTask";
    }

    @Override
    public int sort() {
        return 0;
    }
}