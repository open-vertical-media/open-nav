package openverticalmedia.opennav.nav.entity.page;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import openverticalmedia.opennav.nav.convert.ListTemplateItemConvert;
import openverticalmedia.opennav.nav.convert.SeoMetaConvert;
import openverticalmedia.opennav.nav.entity.NavEntity;
import openverticalmedia.opennav.nav.meta.SeoMeta;
import openverticalmedia.opennav.nav.model.TemplateItem;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@Where(clause = "is_delete=0")
@Table(name = "nav_page_template")
@EqualsAndHashCode(callSuper = true)
@SQLDelete(sql = "update nav_page_template set is_delete=1 where id = ?")
public class TemplateEntity extends NavEntity {
    /**
     * SEO信息
     */
    @Convert(converter = SeoMetaConvert.class)
    private SeoMeta seo;
    /**
     * 模板信息
     */
    @Convert(converter = ListTemplateItemConvert.class)
    private List<TemplateItem> items;
}
