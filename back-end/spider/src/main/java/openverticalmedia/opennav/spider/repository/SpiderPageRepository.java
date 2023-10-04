package openverticalmedia.opennav.spider.repository;

import openverticalmedia.opennav.spider.entity.SpiderPageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpiderPageRepository extends JpaRepository<SpiderPageEntity,Long> {
    boolean existsBySiteIdAndUrl(long id,String url);
}
