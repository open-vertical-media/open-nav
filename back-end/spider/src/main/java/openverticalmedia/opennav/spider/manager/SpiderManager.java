package openverticalmedia.opennav.spider.manager;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.http.HttpUtil;
import openverticalmedia.opennav.spider.mapper.DocumentBuilder;
import openverticalmedia.opennav.spider.mapper.SiteMapper;
import openverticalmedia.opennav.spider.model.DocumentModel;
import openverticalmedia.opennav.spider.model.LinkModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SpiderManager {
    @Autowired
    SiteMapper siteMapper;

    public DocumentModel get(String url) {
        //TODO Html乱码问题
        String html = HttpUtil.get(url, 5000);
        Document document = Jsoup.parse(html);
        DocumentBuilder builder = DocumentBuilder.builder();
        builder.body(document.body().html());
        String domain = URLUtil.getHost(URLUtil.url(url)).getHost();
        builder.domain(domain);
        builder.title(document.title());
        //TODO 相对链接问题
        List<LinkModel> links = document.getElementsByTag("a")
                .stream()
                .filter(a -> a.hasAttr("href") && StrUtil.isNotBlank(a.attributes().get("href")))
                .map(siteMapper::nodeToModel)
                .collect(Collectors.toList());

        List<LinkModel> sites = links
                .stream()
                .filter(h -> !URLUtil.url(h.getDomain()).getHost().equals(domain))
                .collect(Collectors.toList());
        builder.sites(sites);

        List<LinkModel> pages = links
                .stream()
                .filter(
                        h -> URLUtil.url(h.getDomain()).getHost().equals(domain) ||
                        h.getDomain().startsWith("/")
                )
                .collect(Collectors.toList());
        builder.pages(pages);

        return builder.build();
    }
}