package openverticalmedia.opennav.intention.repository;

import openverticalmedia.opennav.intention.entity.IntentionEntity;
import openverticalmedia.opennav.intention.entity.IntentionRecordEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IntentionRecordRepository extends JpaRepository<IntentionEntity,Long> {
    @Query("select e from IntentionRecordEntity e where " +
            "(?1 is null or e.partnerId=?1) and " +
            "(?2 is null or e.name like concat('%',?2,'%')) and " +
            "(?3 is null or e.telephone like concat('%',?3,'%'))")
    Page<IntentionRecordEntity> query(Long partnerId,String name,String telephone);
}
