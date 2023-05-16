package projects.mbti.domain;

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

    private Long studentId;
    private String Major;
    private int age;
    private String gender;
    private Long loginNaver;
    private Long loginKakao;
    private Long loginGoogle;


    @OneToMany(mappedBy = "user")
    private List<StaticsGraph> staticsGraph = new ArrayList<>(); // 컬렉션은 필드에서 초기화


}
