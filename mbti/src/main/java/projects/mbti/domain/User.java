package projects.mbti.domain;

import lombok.Getter;
import lombok.Setter;
import projects.mbti.domain.statistics.StatisticsBarGraph;

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
    private String major;
    private int age;
    private String gender;
    private Long loginByNaver;
    private Long loginByKakao;
    private Long loginByGoogle;


    @OneToMany(mappedBy = "user")
    private List<StatisticsBarGraph> staticsGraph = new ArrayList<>(); // 컬렉션은 필드에서 초기화


}
