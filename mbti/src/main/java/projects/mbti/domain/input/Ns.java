package projects.mbti.domain.input;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Ns")
@Getter
@Setter
public class Ns extends Input {

    private String tendency;


}
