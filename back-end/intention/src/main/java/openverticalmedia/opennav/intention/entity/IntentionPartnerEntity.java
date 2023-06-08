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
@EqualsAndHashCode(callSuper = true)
@Table(name = "nav_intention_partner")
@SQLDelete(sql = "update nav_intention_partner set is_delete=1 where id = ?")
public class IntentionPartnerEntity extends IntentionEntity {
    /**
     * 名称
     */
    private String name;
    /**
     * 剩余额度
     */
    private int quota;
}
