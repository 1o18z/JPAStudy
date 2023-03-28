package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        // 엔티티 매니저 팩토리는 하나만 생성해서 애플리케이션 전체에서 공유 (스레드 간에 공유X. 사용하고 버려야 한다)
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin(); // 트랜잭션 시작

        try {
            // 비영속
//            Member member = new Member();
//            member.setId(100L);
//            member.setName("Hello JPA");
//
//            // 영속
//            em.persist(member);

            Member member1 = new Member(200L, "member200");
            em.persist(member1);
            System.out.println("=================");

            // 커밋되기 전에는 쿼리를 볼 수 없는데 미리 데이터베이스에 반영하고 싶거나 쿼리가 날라가는 걸 보고싶으면
            // em.flush()로 강제로 호출
            em.flush();

            System.out.println("=================");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); // 엔티티 매니저 닫는 게 정말 중요! -> 내부적으로 데이터베이스를 물고 동작하기 때문!
        }


        emf.close();
    }
}
