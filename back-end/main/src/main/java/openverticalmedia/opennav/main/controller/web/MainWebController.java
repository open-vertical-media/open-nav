package openverticalmedia.opennav.main.controller.web;

import openverticalmedia.opennav.common.annotation.WebController;
import openverticalmedia.opennav.main.config.WebProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@WebController("web")
public class MainWebController {
    @Autowired
    WebProperties properties;
    @GetMapping("partner")
    public String partner(Model model){
        model.addAttribute("model",properties);
        return "partner";
    }
    @GetMapping("admin")
    public String admin(Model model){
        model.addAttribute("model",properties);
        return "admin";
    }
}
