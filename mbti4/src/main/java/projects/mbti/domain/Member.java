package projects.mbti.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter @Getter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private Long studentId;
    private String major;

    private String loginInfo;

    private int age;

    private String gender;



}
