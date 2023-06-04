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
@Table(name = "nav_intention_partner")
@EqualsAndHashCode(callSuper = true)
public class IntentionPartnerEntity extends IntentionEntity {
    /**
     * 名称
     */
    private String name;
}
