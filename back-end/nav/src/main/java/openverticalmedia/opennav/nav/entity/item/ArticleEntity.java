package openverticalmedia.opennav.nav.entity.item;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import openverticalmedia.opennav.nav.meta.ContentMeta;
import openverticalmedia.opennav.nav.meta.MediumMeta;
import openverticalmedia.opennav.nav.meta.SeoMeta;
import openverticalmedia.opennav.nav.entity.NavEntity;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;


@Getter
@Setter
@Entity
@Where(clause = "is_delete=0")
@Table(name = "nav_item_article")
@EqualsAndHashCode(callSuper = true)
@SQLDelete(sql = "update nav_item_article set is_delete=1 where id = ?")
public class ArticleEntity extends NavEntity {
    /**
     * 媒体数据
     */
    private MediumMeta mediun;
    /**
     * 内容数据
     */
    private ContentMeta content;
    /**
     * SEO数据
     */
    private SeoMeta seo;
}
