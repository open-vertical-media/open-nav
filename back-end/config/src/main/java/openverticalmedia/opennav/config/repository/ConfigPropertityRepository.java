package openverticalmedia.opennav.config.repository;

import openverticalmedia.opennav.config.entity.ConfigPropertityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfigPropertityRepository extends JpaRepository<ConfigPropertityEntity,Long> {
    List<ConfigPropertityEntity> findByKeyOrderByVersionDesc(String key);
}
