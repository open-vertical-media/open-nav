package openverticalmedia.opennav.intention.entity.record;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import openverticalmedia.opennav.intention.entity.IntentionEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "nav_intention_record")
@EqualsAndHashCode(callSuper = true)
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

}
