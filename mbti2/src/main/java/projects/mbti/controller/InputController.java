package projects.mbti.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import projects.mbti.controller.InputForm;
import projects.mbti.domain.Input;
import projects.mbti.repository.UserRepository;
import projects.mbti.service.InputService;
import projects.mbti.service.UserService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class InputController {

    private final UserService userService;

    @GetMapping("/users/createUserForm")
    public String createUserForm(Model model){
        model.addAttribute("inputForm", new InputForm());
        return "users/createUserForm";
    }



    @GetMapping("/input/EI")
    public String createEIForm(Model model){
        model.addAttribute("inputForm", new InputForm());
        return "input/createInputEIForm";
    }

    @PostMapping("/input/EI")
    public String createEI(@RequestParam("value") String value, @Valid InputForm form){
        return "input/createInputNSForm";
    }

    @GetMapping("/input/NS")
    public String createNSForm(Model model){
        model.addAttribute("inputForm", new InputForm());
        return "input/createInputNSForm";
    }

    @PostMapping("/input/NS")
    public String createNS(@Valid InputForm form){

        return "input/createInputTFForm";
    }

    @GetMapping("/input/TF")
    public String createTFForm(Model model){
        model.addAttribute("inputForm", new InputForm());
        return "input/createInputTFForm";
    }

    @PostMapping("/input/TF")
    public String createTF(@Valid InputForm form){



        return "input/createInputPJForm";
    }

    @GetMapping("/input/PJ")
    public String createPJForm(Model model){
        model.addAttribute("inputForm", new InputForm());
        return "input/createInputPJForm";
    }

    @PostMapping("/input/PJ")
    public String createPJ(@Valid InputForm form){


        return "result/inputResult";
    }
}
