package openverticalmedia.opennav.intention.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import openverticalmedia.opennav.intention.entity.IntentionEntity;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;


@Getter
@Setter
@Entity
@Where(clause = "is_delete=0")
@Table(name = "nav_intention_quota")
@EqualsAndHashCode(callSuper = true)
@SQLDelete(sql = "update nav_intention_quota set is_delete=1 where id = ?")
public class IntentionQuotaEntity extends IntentionEntity {
    /**
     * 类型
     * 充值/扣减
     */
    private String type;
    /**
     * 数量
     */
    private int number;
    /**
     *
     */
    private long partnerId;
    /**
     *
     */
    private long recordId;
}
