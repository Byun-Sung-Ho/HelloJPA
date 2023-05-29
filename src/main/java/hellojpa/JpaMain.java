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
            //insert into
            Member member = new Member();
            member.setId(1L);
            member.setName("HelloA");
            //update
//            Member mem2 = entityManager.find(Member.class, 2L);
//            mem2.setName("HelloJPA");
            entityManager.persist(member);

            //select *
//            List<Member> resultList = entityManager.createQuery("select m from Member as m", Member.class).getResultList();
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            entityManager.close();
        }
        emf.close();
    }
}
