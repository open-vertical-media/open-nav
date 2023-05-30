package me.pcaz.opennav.nav.repository.aggregation;

import me.pcaz.opennav.nav.entity.aggregation.FeedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedRepository extends JpaRepository<FeedEntity,Long> {
}
