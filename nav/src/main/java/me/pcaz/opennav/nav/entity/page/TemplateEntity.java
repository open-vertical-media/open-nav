package me.pcaz.opennav.nav.entity.page;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import me.pcaz.opennav.nav.entity.NavEntity;
import me.pcaz.opennav.nav.meta.SeoMeta;
import me.pcaz.opennav.nav.model.TemplateItem;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "nav_page_template")
@EqualsAndHashCode(callSuper = true)
public class TemplateEntity extends NavEntity {
    /**
     * SEO信息
     */
    private SeoMeta seo;
    /**
     * 模板信息
     */
    private List<TemplateItem> items;
}
