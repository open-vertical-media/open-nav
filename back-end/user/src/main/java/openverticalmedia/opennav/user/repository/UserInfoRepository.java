package openverticalmedia.opennav.user.repository;

import openverticalmedia.opennav.user.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfoEntity,Long> {
}
