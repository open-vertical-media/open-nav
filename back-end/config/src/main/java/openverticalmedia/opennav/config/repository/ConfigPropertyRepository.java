package openverticalmedia.opennav.config.repository;

import openverticalmedia.opennav.config.entity.ConfigPropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfigPropertyRepository extends JpaRepository<ConfigPropertyEntity,Long> {
    List<ConfigPropertyEntity> findByKeyOrderByVersionDesc(String key);
}
