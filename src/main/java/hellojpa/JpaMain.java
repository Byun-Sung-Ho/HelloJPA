package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager entityManager = emf.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
//            //비영속
//            //insert into
//            Member member = new Member();
//            member.setId(100L);
//            member.setName("HelloJPA2");
//            //update
////            Member mem2 = entityManager.find(Member.class, 2L);
////            mem2.setName("HelloJPA");
//            //영속
//            entityManager.persist(member);
//
//            //select *
////            List<Member> resultList = entityManager.createQuery("select m from Member as m", Member.class).getResultList();
//            Member member1 = entityManager.find(Member.class, 1L);
//            System.out.println("member1 = " + member1);

            //========================================================
            //영속성 컨텍스트 트랙잭션 동작
            Member member1 = new Member(150L, "A");
            Member member2 = new Member(151L, "B");

            entityManager.persist(member1);
            entityManager.persist(member2);
            System.out.println("==========================");

            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            entityManager.close();
        }
        emf.close();
    }
}
