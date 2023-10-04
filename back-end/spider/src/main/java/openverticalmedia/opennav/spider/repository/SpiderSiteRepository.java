package openverticalmedia.opennav.spider.repository;

import openverticalmedia.opennav.spider.entity.SpiderSiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpiderSiteRepository  extends JpaRepository<SpiderSiteEntity,Long> {
    boolean existsByDomain(String domain);
    Optional<SpiderSiteEntity> findByDomain(String domain);
}