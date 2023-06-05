package openverticalmedia.opennav.auth.entity.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import openverticalmedia.opennav.auth.entity.AuthEntity;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "nav_user")
@Where(clause = "is_delete=0")
@EqualsAndHashCode(callSuper = true)
@SQLDelete(sql = "update nav_user set is_delete=1 where id = ?")
public class UserEntity extends AuthEntity {
    private String name;
    private String password;
}
