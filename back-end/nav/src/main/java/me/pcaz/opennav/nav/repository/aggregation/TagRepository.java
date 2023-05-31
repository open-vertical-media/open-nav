package me.pcaz.opennav.nav.repository.aggregation;

import me.pcaz.opennav.nav.entity.aggregation.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<TagEntity,Long> {
}
