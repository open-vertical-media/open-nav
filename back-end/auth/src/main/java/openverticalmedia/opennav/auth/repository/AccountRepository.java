package openverticalmedia.opennav.auth.repository;

import openverticalmedia.opennav.auth.entity.AccountEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity,Long> {
    Optional<AccountEntity> findByNameAndPassword(String name, String password);
    @Query("select a from AccountEntity a where ?1 is null or a.name like concat('%',?1,'%')")
    Page<AccountEntity> query(String name,Pageable pageable);
}
