package openverticalmedia.opennav.spider.mapper;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import openverticalmedia.opennav.spider.dto.SpiderSiteData;
import openverticalmedia.opennav.spider.entity.SpiderSiteEntity;
import openverticalmedia.opennav.spider.model.DocumentModel;
import openverticalmedia.opennav.spider.model.LinkModel;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SiteMapper {
    public SpiderSiteEntity modelFillEntity(SpiderSiteEntity entity, DocumentModel model) {
        entity.setTitle(model.getTitle());
        entity.setDomain(model.getDomain());
        return entity;
    }

    public SpiderSiteEntity dataToEntity(SpiderSiteData data) {
        SpiderSiteEntity entity = new SpiderSiteEntity();
        entity.setDomain(data.getDomain());
        return entity;
    }

    public LinkModel nodeToModel(Element element) {
        LinkModel linkModel = new LinkModel();
        linkModel.setUrl(element.attributes().get("href"));
        linkModel.setName(element.text());
        String domain = URLUtil.url(linkModel.getUrl()).getHost();
        List<String> urls = StrUtil.split(domain, '.');
        urls = urls.size() > 2 ? ListUtil.sub(urls, urls.size() - 2, urls.size()) : urls;
        domain = StrUtil.join(".", urls);
        linkModel.setDomain(domain);
        return linkModel;
    }
}