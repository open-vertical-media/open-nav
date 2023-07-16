package openverticalmedia.opennav.intention.repository;

import openverticalmedia.opennav.intention.entity.IntentionPartnerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.beans.Transient;

@Repository
public interface IntentionPartnerRepository extends JpaRepository<IntentionPartnerEntity,Long> {
    Page<IntentionPartnerEntity> findAllByNameLike(String name, Pageable pageable);
}
