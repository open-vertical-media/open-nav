package openverticalmedia.opennav.nav.service;

import openverticalmedia.opennav.nav.repository.page.TemplateRepository;
import openverticalmedia.opennav.nav.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebNavService {
    @Autowired
    TemplateRepository repository;

    public PageVo index(){
        return null;
    }
}
