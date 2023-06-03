package openverticalmedia.opennav.nav.repository.aggregation;

import openverticalmedia.opennav.nav.entity.aggregation.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
}
