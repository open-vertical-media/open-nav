package openverticalmedia.opennav.nav.repository.aggregation;

import openverticalmedia.opennav.nav.entity.aggregation.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<TagEntity,Long> {
}
