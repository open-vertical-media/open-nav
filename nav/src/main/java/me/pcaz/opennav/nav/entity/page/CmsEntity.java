package me.pcaz.opennav.nav.entity.page;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import me.pcaz.opennav.nav.entity.NavEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "nav_page_cms")
@EqualsAndHashCode(callSuper = true)
public class CmsEntity extends NavEntity {
}
