package openverticalmedia.opennav.nav.entity.page;


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
@Table(name = "nav_page_cms")
@Where(clause = "is_delete=0")
@EqualsAndHashCode(callSuper = true)
@SQLDelete(sql = "update nav_page_cms set is_delete=1 where id = ?")
public class CmsEntity extends NavEntity {
}
