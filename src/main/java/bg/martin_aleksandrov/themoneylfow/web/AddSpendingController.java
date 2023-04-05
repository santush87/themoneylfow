package bg.martin_aleksandrov.themoneylfow.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class AddSpendingController {

    @GetMapping("/add")
    public String getAdd(){
        return "add";
    }

    @GetMapping("/a")
    public String getA(){
        return "index";
    }
}
