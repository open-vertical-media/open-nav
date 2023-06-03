package openverticalmedia.opennav.auth.repository;

import openverticalmedia.opennav.auth.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findByNameAndPassword(String name,String password);

}
