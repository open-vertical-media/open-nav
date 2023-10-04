package openverticalmedia.opennav.spider.mapper;

import openverticalmedia.opennav.spider.model.DocumentModel;
import openverticalmedia.opennav.spider.model.LinkModel;

import java.util.List;

public class DocumentBuilder {
    private DocumentModel model;
    public DocumentBuilder(DocumentModel model){
        this.model=model;
    }
    public static DocumentBuilder builder(){
        return new DocumentBuilder(new DocumentModel());
    }
    public DocumentBuilder title(String title){
        model.setTitle(title);
        return this;
    }
    public DocumentBuilder body(String body){
        model.setBody(body);
        return this;
    }
    public DocumentBuilder domain(String domain){
        model.setDomain(domain);
        return this;
    }
    public DocumentBuilder sites(List<LinkModel> links){
        model.setSites(links);
        return this;
    }
    public DocumentBuilder pages(List<LinkModel> pages){
        model.setPages(pages);
        return this;
    }
    public DocumentModel build(){
        return model;
    }
}
