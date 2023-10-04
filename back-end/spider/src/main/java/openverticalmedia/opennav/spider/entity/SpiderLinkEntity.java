package openverticalmedia.opennav.spider.entity;

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
@Table(name = "nav_spider_link")
@EqualsAndHashCode(callSuper = true)
@SQLDelete(sql = "update nav_spider_link set is_delete=1 where id = ?")
public class SpiderLinkEntity extends SpiderEntity {
    private String name;
    private long fromSiteId;
    private long toSiteId;
    private String fromSiteUrl;
    private String toSiteUrl;
}
