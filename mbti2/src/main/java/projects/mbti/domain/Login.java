package projects.mbti.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Login {


    @Id
    @GeneratedValue
    @Column(name = "login_id")
    private Long id;

    private String authId;

    private String password;

    private Long phoneNum;

    private String email;

    public Login(Long phoneNum, String password, String email, String authId) {
        this.authId = authId;
        this.email = email;
        this.password = password;
        this.phoneNum = phoneNum;
    }
}
