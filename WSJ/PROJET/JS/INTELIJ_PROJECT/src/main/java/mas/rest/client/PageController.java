package mas.rest.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by seb on 27.11.14.
 */
@Controller
class PageController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("tutu","toto");
        return "index";
    }
}
