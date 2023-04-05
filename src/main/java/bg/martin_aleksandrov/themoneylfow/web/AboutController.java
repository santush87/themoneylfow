package bg.martin_aleksandrov.themoneylfow.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

    @GetMapping("/about")
    public String getAbout(){
        return "about";
    }
}
