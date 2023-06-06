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
@Table(name = "nav_intention_request")
@EqualsAndHashCode(callSuper = true)
@SQLDelete(sql = "update nav_intention_request set is_delete=1 where id = ?")
public class IntentionRequestEntity extends IntentionEntity {
    /**
     * 合作伙伴ID
     */
    private long partnerId;
    /**
     * 关联类型
     */
    private String relationType;
    /***
     * 关联ID
     */
    private long relationId;
}
