package openverticalmedia.opennav.nav.entity.aggregation;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import openverticalmedia.opennav.nav.entity.NavEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "nav_aggregation_category")
@EqualsAndHashCode(callSuper = true)
public class CategoryEntity extends NavEntity {
}
