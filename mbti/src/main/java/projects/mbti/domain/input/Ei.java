package projects.mbti.domain.input;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Ei")
@Getter
@Setter
public class Ei extends Input {

    private String tendency;


}
