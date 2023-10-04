package openverticalmedia.opennav.spider.repository;

import openverticalmedia.opennav.spider.entity.SpiderLinkEntity;
import openverticalmedia.opennav.spider.entity.SpiderPageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpiderLinkRepository extends JpaRepository<SpiderLinkEntity,Long> {
}
