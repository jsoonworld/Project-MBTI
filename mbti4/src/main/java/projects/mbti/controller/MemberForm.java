package projects.mbti.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class MemberForm {

    @NotNull(message = "학번을 입력하시오.")
    private Long studentId;

    @NotNull(message = "학과를 선택하시오.")
    private String major;

    private String loginInfo;

    private int age;

    private String gender;
}
