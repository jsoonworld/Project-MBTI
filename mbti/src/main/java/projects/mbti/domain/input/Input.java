package projects.mbti.domain.input;

import lombok.Getter;
import lombok.Setter;
import projects.mbti.domain.TendencyStatus;
import projects.mbti.domain.User;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    @Enumerated(EnumType.STRING)
    private TendencyStatus status; // [E, I, N, S, F, T, J, P]



}
