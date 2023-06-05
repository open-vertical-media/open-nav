package openverticalmedia.opennav.sso.repository;

import openverticalmedia.opennav.sso.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity,Long> {
}