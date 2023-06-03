package openverticalmedia.opennav.auth.entity.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import openverticalmedia.opennav.auth.entity.AuthEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "nav_user")
@EqualsAndHashCode(callSuper = true)
public class UserEntity extends AuthEntity {
    private String name;
    private String password;
}
