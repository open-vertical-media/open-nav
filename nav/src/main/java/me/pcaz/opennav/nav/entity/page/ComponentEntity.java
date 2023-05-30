package me.pcaz.opennav.nav.entity.page;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import me.pcaz.opennav.nav.entity.NavEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

/**
 * 组件
 */
@Getter
@Setter
@Entity
@Table(name = "nav_page_Component")
@EqualsAndHashCode(callSuper = true)
public class ComponentEntity extends NavEntity {
    /**
     * 名称
     */
    private String name;
    /**
     * 插槽名称集合
     */
    private List<String> slotNames;

}
