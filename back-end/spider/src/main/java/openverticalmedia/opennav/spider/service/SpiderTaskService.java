package openverticalmedia.opennav.spider.service;

import cn.hutool.json.JSONUtil;
import openverticalmedia.opennav.sdk.task.TaskModel;
import openverticalmedia.opennav.sdk.task.TaskTemplate;
import openverticalmedia.opennav.spider.config.SpiderProperties;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpiderTaskService {
    @Autowired
    SpiderManager spiderManager;
    @Autowired
    SiteMapper mapper;
    @Autowired
    SpiderSiteRepository siteRepository;
    @Autowired
    SpiderPageRepository pageRepository;
    @Autowired
    SpiderLinkRepository linkRepository;
    @Autowired
    TaskTemplate taskTemplate;
    @Autowired
    SpiderProperties properties;

    public void run(String param) {
        //先处理Page 后处理Site
        SpiderTaskModel model = JSONUtil.toBean(param, SpiderTaskModel.class);
        DocumentModel documentModel = spiderManager.get(model.getUrl());
        long id = model.getId();
        long siteId = 0;
        if ("Site".equals(model.getType())) {
            SpiderSiteEntity entity = siteRepository.findById(id).get();
            entity = mapper.modelFillEntity(entity, documentModel);
            entity.setStatus("Loading");
            siteRepository.saveAndFlush(entity);
            siteId = id;
        } else if ("Page".equals(model.getType())) {
            SpiderPageEntity page = pageRepository.findById(id).get();
            siteId = page.getSiteId();
        }
        newSites(siteId, model.getUrl(), documentModel.getSites());
        newPages(siteId,documentModel.getPages());
    }

    private void newPages(long sieId, List<LinkModel> links) {
        for (LinkModel link : links) {
            SpiderPageEntity entity;
            boolean exists = pageRepository.existsBySiteIdAndUrl(sieId, link.getUrl());
            if(!exists){
                entity=new SpiderPageEntity();
                entity.setSiteId(sieId);
                entity.setUrl(link.getUrl());
                pageRepository.save(entity);
                pageRepository.flush();
                //TODO addTask
                TaskModel taskModel=new TaskModel();
                taskModel.setName("spiderTaskController");
                SpiderTaskModel spiderTaskModel=new SpiderTaskModel();
                spiderTaskModel.setType("Page");
                spiderTaskModel.setId(entity.getId());
                spiderTaskModel.setUrl(link.getUrl());
                taskModel.setParam(JSONUtil.toJsonStr(spiderTaskModel));
                taskTemplate.add(taskModel);
            }
        }
    }

    private void newSites(long sieId,String url,List<LinkModel> sites) {
        for (LinkModel site : sites) {
            SpiderSiteEntity entity;
            Optional<SpiderSiteEntity> domainOptional = siteRepository.findByDomain(site.getDomain());
            if (domainOptional.isPresent()) {
                entity = domainOptional.get();
            } else {
                entity = new SpiderSiteEntity();
                entity.setDomain(site.getDomain());
                entity = siteRepository.save(entity);
                //TODO addTask
                TaskModel taskModel=new TaskModel();
                taskModel.setName("spiderTaskController");
                SpiderTaskModel spiderTaskModel=new SpiderTaskModel();
                spiderTaskModel.setType("Site");
                spiderTaskModel.setId(entity.getId());
                spiderTaskModel.setUrl(site.getUrl());
                taskModel.setParam(JSONUtil.toJsonStr(spiderTaskModel));
                taskTemplate.add(taskModel);
            }
            //Link
            SpiderLinkEntity link=new SpiderLinkEntity();
            link.setFromSiteId(sieId);
            link.setFromSiteUrl(url);
            link.setToSiteId(entity.getId());
            link.setToSiteUrl(site.getUrl());
            link.setName(site.getName());
            linkRepository.save(link);
        }
        siteRepository.flush();
    }
}
