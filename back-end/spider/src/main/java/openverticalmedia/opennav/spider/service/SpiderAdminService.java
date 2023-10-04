package openverticalmedia.opennav.spider.service;

import openverticalmedia.opennav.spider.dto.SpiderSiteData;
import openverticalmedia.opennav.spider.entity.SpiderSiteEntity;
import openverticalmedia.opennav.spider.manager.SpiderHandler;
import openverticalmedia.opennav.spider.mapper.SiteMapper;
import openverticalmedia.opennav.spider.repository.SpiderSiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpiderAdminService {
    @Autowired
    SpiderSiteRepository repository;
    @Autowired
    SiteMapper mapper;
    @Autowired
    SpiderHandler handler;

    public Long post(SpiderSiteData data){
        boolean exists = repository.existsByDomain(data.getDomain());
        if(exists){
            return 0L;
        }
        SpiderSiteEntity entity = mapper.dataToEntity(data);
        entity=repository.save(entity);
        handler.save(entity);
        return entity.getId();
    }
}
