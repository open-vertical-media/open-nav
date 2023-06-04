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
@Table(name = "nav_intention_plant")
@EqualsAndHashCode(callSuper = true)
public class IntentionPlantEntity extends IntentionEntity {
    private String path;
    private long partnerId;
}
