package openverticalmedia.opennav.nav.entity.item;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import openverticalmedia.opennav.nav.entity.NavEntity;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Where(clause = "is_delete=0")
@Table(name = "nav_item_link")
@EqualsAndHashCode(callSuper = true)
@SQLDelete(sql = "update nav_item_link set is_delete=1 where id = ?")
public class LinkEntity extends NavEntity {
}
