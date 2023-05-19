package projects.mbti.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class Input {

    public Input() {
    }

    public Input(String EI, String NS, String FT, String JP) {
        setMbti(EI, NS, FT, JP);
    }

    @Id
    @GeneratedValue
    @Column(name = "input_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public void setUser(User user) {
        this.user = user;
        user.setInput(this);
    }

    @Column(name = "EI")
    private String EI;

    @Column(name = "NS")
    private String NS;

    @Column(name = "FT")
    private String FT;

    @Column(name = "JP")
    private String JP;

    @Column(name = "fullOfMbti")
    private String fullOfMbti;

    public void setMbti(String EI, String NS, String FT, String JP) {
        this.fullOfMbti = EI + NS + FT + JP;
    }

}
