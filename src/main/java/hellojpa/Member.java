package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // 이걸 넣어야 JPA를 사용한다는 걸 인식
// 만약 데이터베이스에 Member가 아닌 다른 이름(예를 들어 USER)이라면 아래처럼 추가
// @Table(name = "USER")
public class Member {

    @Id
    private Long id;
    // 컬럼 이름이 DB와 다르면 @Column(name="username") 이런 식으로 추가!
    private String name;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
