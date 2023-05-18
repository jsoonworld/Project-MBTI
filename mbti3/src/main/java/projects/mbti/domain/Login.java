package projects.mbti.domain;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

public class Login {
    @Id
    @GeneratedValue
    @Column(name = "login_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
