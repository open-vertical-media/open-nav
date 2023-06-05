package openverticalmedia.opennav.nav.entity.aggregation;

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
@EqualsAndHashCode(callSuper = true)
@Table(name = "nav_aggregation_category")
@SQLDelete(sql = "update nav_aggregation_category set is_delete=1 where id = ?")
public class CategoryEntity extends NavEntity {
}
