package me.pcaz.opennav.nav.entity.aggregation;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import me.pcaz.opennav.nav.entity.NavEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "nav_aggregation_tag")
@EqualsAndHashCode(callSuper = true)
public class TagEntity extends NavEntity {
}
