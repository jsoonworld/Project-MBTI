package projects.mbti.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class UserForm {

    @NotEmpty(message = "학번을 입력하시오.")
    private Long studentId;

    @NotEmpty(message = "학과를 입력하시오.")
    private String major;


}
