package openverticalmedia.opennav.advert.repository;

import openverticalmedia.opennav.advert.entity.PageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertPageRepository extends JpaRepository<PageEntity,Long> {
}
