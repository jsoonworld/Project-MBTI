package projects.mbti.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import projects.mbti.controller.inputForm.InputEiForm;
import projects.mbti.controller.inputForm.InputFtForm;
import projects.mbti.controller.inputForm.InputJpForm;
import projects.mbti.controller.inputForm.InputNsForm;
import projects.mbti.domain.input.Ei;
import projects.mbti.service.InputService;

@Controller
@RequiredArgsConstructor
public class InputController {

    private final InputService inputService;

    @GetMapping("/inputs/EI")
    public String createEiForm(Model model) {
        model.addAttribute("form", new InputEiForm());
        return "inputs/createInputForm/EI";
    }

    @PostMapping("/inputs/EI")
    public String create(InputFtForm form) {
        Ei ei = new Ei();
        ei.setTendencyKind(form.getTendency());

        inputService.saveItem(ei);
        return "redirect:/";
    }



    @GetMapping("/inputs/NS")
    public String createNsForm(Model model) {
        model.addAttribute("form", new InputNsForm());
        return "inputs/createInputForm/NS";
    }

    @GetMapping("/inputs/FT")
    public String createFtForm(Model model) {
        model.addAttribute("form", new InputFtForm());
        return "inputs/createInputForm/FT";
    }

    @GetMapping("/inputs/JP")
    public String createJpForm(Model model) {
        model.addAttribute("form", new InputJpForm());
        return "inputs/createInputForm/JP";
    }

    @GetMapping("inputs/{inputId}/edit")
    public String updateItemEiForm(@PathVariable("inputId") Long inputId, Model model) {
        Ei item = (Ei) inputService.findOne(inputId);

        InputEiForm form = new InputEiForm();
        form.setId(item.getId());
        form.setTendency(item.getTendency());

        model.addAttribute("form", form);
        return "inputs/inputList/EI";
    }
}
