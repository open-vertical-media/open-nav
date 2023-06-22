package openverticalmedia.opennav.config.service;

import openverticalmedia.opennav.config.entity.ConfigPropertyEntity;
import openverticalmedia.opennav.config.repository.ConfigPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "property")
public class TemplateConfigPropertyService {
    @Autowired
    ConfigPropertyRepository repository;

    @Cacheable(key = "#key", unless = "#result==null")
    public String get(String key){
        List<ConfigPropertyEntity> properties = repository.findByKeyOrderByVersionDesc(key);
        if(properties.size()>0){
            return properties.get(0).getValue();
        }
        return null;
    }
}
