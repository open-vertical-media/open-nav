package openverticalmedia.opennav.nav.repository.page;

import openverticalmedia.opennav.nav.entity.page.CmsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CmsRepository extends JpaRepository<CmsEntity,Long> {
}
