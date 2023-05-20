package projects.mbti.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
public class Input {
    @Id
    @GeneratedValue
    @Column(name = "input_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String EI;

    private String NS;

    private String FT;

    private String JP;

    private String mbtiResult;

    //==비즈니스 로직 ==//

    public void sumMbti(String splitedMbti){
        this.mbtiResult += splitedMbti;
    }




}
