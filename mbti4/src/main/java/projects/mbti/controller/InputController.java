package projects.mbti.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import projects.mbti.domain.Input;
import projects.mbti.service.InputService;
import projects.mbti.service.MemberService;

@Controller
@RequiredArgsConstructor
public class InputController {

    private final InputService inputService;

    @GetMapping("/inputs/createInputEIForm")
    public String createMemberEIForm(Model model){
        model.addAttribute("inputForm", new InputForm());
        return "/inputs/createInputEIForm";
    }

    @PostMapping("/inputs/createInputEIForm")
    public String setMemberEIForm(InputForm form) {

        Input input = new Input();
        input.setEI(form.getEI());

        inputService.save(input);

        return "/inputs/createInputEIForm";
    }

    @GetMapping("/inputs/createInputNSForm")
    public String createMemberNSForm(Model model){
        model.addAttribute("inputForm", new InputForm());
        return "/inputs/createInputNSForm";
    }

    @PostMapping("/inputs/createInputNSForm")
    public String setMemberNSForm(InputForm form) {

        Input input = new Input();
        input.setEI(form.getNS());

        inputService.save(input);

        return "/inputs/createInputFTForm";
    }



}
