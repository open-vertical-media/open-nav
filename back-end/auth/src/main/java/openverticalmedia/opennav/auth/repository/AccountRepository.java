package openverticalmedia.opennav.auth.repository;

import openverticalmedia.opennav.auth.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity,Long> {
    Optional<AccountEntity> findByNameAndPassword(String name, String password);

}
