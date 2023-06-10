package openverticalmedia.opennav.intention.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Where(clause = "is_delete=0")
@Table(name = "nav_intention_plant")
@EqualsAndHashCode(callSuper = true)
@SQLDelete(sql = "update nav_intention_plant set is_delete=1 where id = ?")
public class IntentionPlantEntity extends IntentionEntity {
    /**
     * 路径
     */
    private String path;
    /**
     *
     */
    private long partnerId;
    /**
     *
     */
    private float sortIndex;
}
