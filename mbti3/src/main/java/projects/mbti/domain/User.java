package projects.mbti.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "major")
    private String major;

    @Column(name = "age")
    private Long age;

    @Column(name = "gender")
    private String gender;

    @Column(name = "login_by_naver")
    private String loginByNaver;

    @Column(name = "login_by_kakao")
    private String loginByKakao;

    @Column(name = "login_by_google")
    private String loginByGoogle;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Input> inputs = new ArrayList<>();
}
