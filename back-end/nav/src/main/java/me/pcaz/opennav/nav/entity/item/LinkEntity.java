package me.pcaz.opennav.nav.entity.item;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import me.pcaz.opennav.nav.entity.NavEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "nav_item_item")
@EqualsAndHashCode(callSuper = true)
public class LinkEntity extends NavEntity {
}
