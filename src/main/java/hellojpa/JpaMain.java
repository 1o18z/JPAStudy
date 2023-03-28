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

        try{
            /*
            삽입
             */
            /*
            Member member = new Member();
            member.setId(2L);
            member.setName("HelloB");
            // JPA에서 데이터를 변경하는 모든 작업은 꼭 트랜잭션 안에서 해야 함

            em.persist(member); // 저장
            */

            /*
            조회
             */
            /*
            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());
            */

            /*
            수정
             */
            /*
            Member findMember = em.find(Member.class, 1L);
            findMember.setName("HelloJPA"); // 값만 바꿔주고 persist 안 해도 자동으로 변경 됨!
            // JPA를 통해서 엔티티를 가져오면 JPA가 이제 관리를 함!
            // JPA가 트랜잭션을 커밋하는 시점에 다 체크를 해서, 변경된 게 있으면 UPDATE 쿼리를 만들어서 다 날린다
            */

            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5) // 5번부터
                    .setMaxResults(8) // 8개 가져와
                    .getResultList();
            for (Member member : result) {
                System.out.println("member.name = " + member.getName());
            }


            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close(); // 엔티티 매니저 닫는 게 정말 중요! -> 내부적으로 데이터베이스를 물고 동작하기 때문!
        }



        emf.close();
    }
}
