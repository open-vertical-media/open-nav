package openverticalmedia.opennav.advert.repository;

import openverticalmedia.opennav.advert.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertScheduleRepository extends JpaRepository<ScheduleEntity,Long> {
}
