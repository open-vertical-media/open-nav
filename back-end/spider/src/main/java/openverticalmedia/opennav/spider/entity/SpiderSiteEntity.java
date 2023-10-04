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
@Table(name = "nav_spider_site")
@EqualsAndHashCode(callSuper = true)
@SQLDelete(sql = "update nav_spider_site set is_delete=1 where id = ?")
public class SpiderSiteEntity extends SpiderEntity {
    /**
     * 域名
     */
    private String domain;
    /**
     * 标题
     */
    private String title;
    /**
     * 关键词
     */
    private long count;
    /**
     * 状态
     * Ready / Loading / Success
     */
    private String status="Ready";
}
