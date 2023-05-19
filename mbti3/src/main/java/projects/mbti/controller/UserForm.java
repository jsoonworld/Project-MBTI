package projects.mbti.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import projects.mbti.domain.User;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Slf4j
public class UserForm {
    @NotEmpty(message = "학번을 입력하시오.")
    private String studentId;

    @NotEmpty(message = "학과를 입력하시오.")
    private String major;

    public User toUser() {
        User user = new User();
        user.setStudentId(Long.parseLong(studentId));
        user.setMajor(major);
        return user;
    }
}

