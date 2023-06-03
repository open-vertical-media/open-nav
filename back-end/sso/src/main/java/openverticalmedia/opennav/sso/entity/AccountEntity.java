package openverticalmedia.opennav.sso.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "sso_account")
@EqualsAndHashCode(callSuper = true)
public class AccountEntity extends SsoEntity {
}
