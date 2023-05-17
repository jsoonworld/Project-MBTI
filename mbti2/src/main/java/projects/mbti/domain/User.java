package projects.mbti.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "major")
    private String major;
    @Column(name = "age")
    private int age;
    @Column(name = "gender")
    private String gender;
    @Column(name = "loginByGoogle")
    private String loginByGoogle;
    @Column(name = "loginByNaver")
    private String loginByNaver;
    @Column(name = "loginByKakao")
    private String loginByKakao;


/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(studentId, user.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentId);
    }
*/
}
