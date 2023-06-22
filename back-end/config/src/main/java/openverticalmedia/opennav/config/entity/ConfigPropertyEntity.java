package openverticalmedia.opennav.config.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "nav_config_property")
@Where(clause = "is_delete=0")
@EqualsAndHashCode(callSuper = true)
@SQLDelete(sql = "update nav_config_property set is_delete=1 where id = ?")
public class ConfigPropertyEntity extends ConfigEntity {
    @Column(name = "property_key")
    private String key;
    @Column(name = "property_value")
    private String value;
    @Column(name = "property_version")
    private String version;
}
