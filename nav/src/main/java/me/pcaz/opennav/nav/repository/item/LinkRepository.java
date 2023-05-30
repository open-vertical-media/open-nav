package me.pcaz.opennav.nav.repository.item;

import me.pcaz.opennav.nav.entity.item.LinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends JpaRepository<LinkEntity,Long> {
}
