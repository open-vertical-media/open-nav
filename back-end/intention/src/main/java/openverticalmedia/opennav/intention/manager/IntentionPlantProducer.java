package openverticalmedia.opennav.intention.manager;

import openverticalmedia.opennav.intention.entity.IntentionPlantEntity;
import openverticalmedia.opennav.intention.repository.IntentionPlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
@CacheConfig(cacheNames = "intention:plant")
public class IntentionPlantProducer {
    @Autowired
    IntentionPlantRepository repository;

    @Cacheable(value = "all")
    public List<IntentionPlantEntity> get() {
        List<IntentionPlantEntity> all = repository.findAll();
        all = all.stream()
                .sorted(Comparator.comparing(IntentionPlantEntity::getSortIndex).reversed())
                .collect(Collectors.toList());
        return all;
    }
}