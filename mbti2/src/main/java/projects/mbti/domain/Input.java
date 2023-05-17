package projects.mbti.domain;

import lombok.Getter;
import lombok.Setter;
import projects.mbti.TendencyStatus;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter
@Setter
public class Input {

    @Id
    @GeneratedValue
    @Column(name = "input_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "EI")
    private String EI;
    @Column(name = "NS")
    private String NS;
    @Column(name = "FT")
    private String FT;
    @Column(name = "PJ")
    private String PJ;
    @Column(name = "allOfInputs")
    private String allOfInputs;
    public String getAllOfInputs() {
        return allOfInputs;
    }
}
