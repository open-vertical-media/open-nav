package me.pcaz.opennav.nav.repository.item;

import me.pcaz.opennav.nav.entity.item.SiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteRepository extends JpaRepository<SiteEntity,Long> {
}
