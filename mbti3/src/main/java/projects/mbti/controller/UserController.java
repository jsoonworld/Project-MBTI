package projects.mbti.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import projects.mbti.domain.User;
import projects.mbti.service.UserService;

import javax.validation.Valid;


@Controller
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users/createUserForm")
    public String createForm(Model model){
        model.addAttribute("userForm", new UserForm());
        return "/users/createUserForm";
    }

    @PostMapping("/users/createUserForm")
    public String create(@Valid UserForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "/users/createUserForm";
        }

        User user = form.toUser(); // UserForm 객체를 User 객체로 변환하여 사용

        try {
            userService.createUser(user);
        } catch (IllegalStateException e) {
            result.rejectValue("studentId", "duplicate", "중복된 사용자입니다.");
            return "/users/createUserForm";
        }

        return "redirect:/input/createInputEIForm";
    }
}
