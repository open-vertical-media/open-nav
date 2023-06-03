package openverticalmedia.opennav.nav.entity.item;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import openverticalmedia.opennav.nav.entity.NavEntity;
import openverticalmedia.opennav.nav.meta.ContentMeta;
import openverticalmedia.opennav.nav.meta.MediumMeta;
import openverticalmedia.opennav.nav.meta.SeoMeta;

import javax.persistence.Entity;
import javax.persistence.Table;


@Getter
@Setter
@Entity
@Table(name = "nav_item_article")
@EqualsAndHashCode(callSuper = true)
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
