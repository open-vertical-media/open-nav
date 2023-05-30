package me.pcaz.opennav.nav.repository.page;

import me.pcaz.opennav.nav.entity.page.TemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateRepository extends JpaRepository<TemplateEntity,Long> {
}
