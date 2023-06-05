package openverticalmedia.opennav.intention.entity.record;

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
@Table(name = "nav_intention_record")
@EqualsAndHashCode(callSuper = true)
@SQLDelete(sql = "update nav_intention_record set is_delete=1 where id = ?")
public class IntentionRecordEntity extends IntentionEntity {
    /**
     * 名称
     */
    private String name;
    /**
     * 手机号
     */
    private String telephone;
    /**
     * 消息
     */
    private String message;
    /**
     * 状态
     */
    private String status;
}
