package openverticalmedia.opennav.nav.controller.web;


import openverticalmedia.opennav.common.annotation.WebController;
import openverticalmedia.opennav.nav.service.WebNavService;
import openverticalmedia.opennav.nav.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@WebController("web/nav")
public class WebNavController {
    @Autowired
    WebNavService service;

    @GetMapping
    public String index(Model model){
        PageVo vo = service.index();
        model.addAttribute("model",vo);
        return "index";
    }
}
