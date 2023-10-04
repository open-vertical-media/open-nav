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
@Table(name = "nav_spider_page")
@EqualsAndHashCode(callSuper = true)
@SQLDelete(sql = "update nav_spider_page set is_delete=1 where id = ?")
public class SpiderPageEntity extends SpiderEntity {
    /**
     * 站点ID
     */
    private long siteId;
    /**
     * 地址
     */
    public String url;
    /**
     * 标题
     */
    private String title;
    /**
     * 关键词
     */
    private String keywords;
    /**
     * 描述
     */
    private String description;
    /**
     * 状态
     * Ready / Success / Failed
     */
    private String status="Ready";
}
