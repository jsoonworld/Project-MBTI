package projects.mbti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    // @RequestMapping("/")
    public String hello(Model model) {
        model.addAttribute("data", "login!!!");
        return "loginApi";

    }
}
