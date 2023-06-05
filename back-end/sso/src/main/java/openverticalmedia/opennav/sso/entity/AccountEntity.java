package openverticalmedia.opennav.sso.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Where(clause = "is_delete=0")
@Table(name = "sso_account")
@EqualsAndHashCode(callSuper = true)
@SQLDelete(sql = "update sso_account set is_delete=1 where id = ?")
public class AccountEntity extends SsoEntity {
}
