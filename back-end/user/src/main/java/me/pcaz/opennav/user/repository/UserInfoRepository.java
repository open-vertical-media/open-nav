package me.pcaz.opennav.user.repository;

import me.pcaz.opennav.user.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfoEntity,Long> {
}
