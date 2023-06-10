package openverticalmedia.opennav.nav.entity.page;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import openverticalmedia.opennav.nav.convert.ListStringConvert;
import openverticalmedia.opennav.nav.entity.NavEntity;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

/**
 * 组件
 */
@Getter
@Setter
@Entity
@Where(clause = "is_delete=0")
@Table(name = "nav_page_component")
@EqualsAndHashCode(callSuper = true)
@SQLDelete(sql = "update nav_page_component set is_delete=1 where id = ?")
public class ComponentEntity extends NavEntity {
    /**
     * 名称
     */
    private String name;
    /**
     * 插槽名称集合
     */
    @Convert(converter = ListStringConvert.class)
    private List<String> slotNames;

}
