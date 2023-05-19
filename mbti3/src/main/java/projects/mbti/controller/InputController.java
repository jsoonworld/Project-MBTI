package projects.mbti.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import projects.mbti.domain.Input;
import projects.mbti.service.InputService;

import javax.validation.Valid;
@Controller
@Slf4j
@RequiredArgsConstructor
public class InputController {

    private final InputService inputService;

    @GetMapping("/input/createInputEIForm")
    public String createEIForm(Model model) {
        model.addAttribute("inputForm", new InputForm());
        return "input/createInputEIForm";
    }

    @PostMapping("/input/createInputEIForm")
    public String createEI(@RequestParam("value") String value) {
        inputService.saveInput(value, "", "", "");  // EI 값 설정
        return "redirect:/input/createInputNSForm";  // 리다이렉트하여 다음 화면으로 이동
    }

    @GetMapping("/input/createInputNSForm")
    public String createNSForm(@RequestParam("value") String value, Model model) {
        InputForm inputForm = new InputForm();
        inputForm.setEI(value);
        model.addAttribute("inputForm", inputForm);
        return "/input/createInputNSForm";
    }

    @PostMapping("/input/createInputNSForm")
    public String createNS(@RequestParam("value") String value) {
        inputService.saveInput("", value, "", "");  // NS 값 설정
        return "/input/createInputFTForm";
    }



    @GetMapping("/input/createInputFTForm")
    public String createFTForm(Model model) {
        model.addAttribute("inputForm", new InputForm());
        return "input/createInputFTForm";
    }

    @PostMapping("/input/createInputFTForm")
    public String createFT(@RequestParam("value") String value) {
        inputService.saveInput("", "", value, "");  // FT 값 설정
        return "input/createInputJPForm";
    }

    @GetMapping("/input/createInputJPForm")
    public String createJPForm(Model model) {
        model.addAttribute("inputForm", new InputForm());
        return "input/createInputJPForm";
    }

    @PostMapping("/input/createInputJPForm")
    public String createJP(@RequestParam("value") String value) {
        inputService.saveInput("", "", "", value);  // JP 값 설정
        return "input/createInputEIForm";
    }



}
