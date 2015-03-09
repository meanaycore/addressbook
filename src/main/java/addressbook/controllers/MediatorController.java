package addressbook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by akhona on 2015/03/09.
 */

@Controller
@RequestMapping("/")
public class MediatorController {

    @RequestMapping
    public String getHomePage()
    {
        return "redirect:/users";
    }
}
