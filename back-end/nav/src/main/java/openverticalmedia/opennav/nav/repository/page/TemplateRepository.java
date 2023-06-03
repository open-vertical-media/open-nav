package openverticalmedia.opennav.nav.repository.page;

import openverticalmedia.opennav.nav.entity.page.TemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateRepository extends JpaRepository<TemplateEntity,Long> {
}
