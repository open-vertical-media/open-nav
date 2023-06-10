package openverticalmedia.opennav.auth.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import openverticalmedia.opennav.auth.convert.ListPowerModelConvert;
import openverticalmedia.opennav.auth.model.PowerModel;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "nav_auth_account")
@Where(clause = "is_delete=0")
@EqualsAndHashCode(callSuper = true)
@SQLDelete(sql = "update nav_auth_account set is_delete=1 where id = ?")
public class AccountEntity extends AuthEntity {
    private String name;
    private String password;
    @Convert(converter = ListPowerModelConvert.class)
    private List<PowerModel> powers;
}
