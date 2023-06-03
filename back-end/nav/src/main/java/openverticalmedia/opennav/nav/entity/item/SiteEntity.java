package openverticalmedia.opennav.nav.entity.item;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import openverticalmedia.opennav.nav.entity.NavEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "nav_item_site")
@EqualsAndHashCode(callSuper = true)
public class SiteEntity extends NavEntity {
}
