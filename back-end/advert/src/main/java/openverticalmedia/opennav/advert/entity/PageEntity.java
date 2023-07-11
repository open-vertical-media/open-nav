package openverticalmedia.opennav.advert.entity;

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
@Table(name = "nav_advert_page")
@Where(clause = "is_delete=0")
@EqualsAndHashCode(callSuper = true)
@SQLDelete(sql = "update nav_advert_page set is_delete=1 where id = ?")
public class PageEntity extends AdvertEntity {
}
