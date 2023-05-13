package projects.mbti.domain.input;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Jp")
@Getter
@Setter
public class Jp extends Input {

    private String tendency;


}
