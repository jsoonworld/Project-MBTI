package projects.mbti.domain.input;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter
@Setter
public abstract class Input {

    @Id
    @GeneratedValue
    @Column(name = "input_id")
    private Long id;

    private String tendencyKind;
}
