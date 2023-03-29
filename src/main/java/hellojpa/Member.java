package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
@TableGenerator(name = "MEMBER_SEQ_GENERATOR",
        table = "MY_SEQUENCES",
        pkColumnValue = "MEMBER_SEQ", allocationSize = 1) // TABLE
//@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq") // SEQUENCE
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "MEMBER_SEQ_GENERATOR") // TABLE

//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator") // SEQUENCE

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    IDENTITY 일 경우에만 em.persist(entity)만으로 (commit 하지 않아도) DB에 들어감
    private Long id;

    @Column(name = "name", nullable = false)
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
