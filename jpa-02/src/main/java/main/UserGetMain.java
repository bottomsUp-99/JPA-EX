package main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpabasic.reserve.domain.User;

public class UserGetMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabegin");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
            User user = em.find(User.class, "seungjoon0324@gmail.com");
            if (user != null){
                System.out.println("해당 유저가 존재합니다!!");
                System.out.printf("User Email : %s / User Name : $s / User CreateDate : %s", user.getEmail(), user.getName(), user.getCreateDate());
            } else {
                System.out.println("해당 유저가 존재하지 않습니다!!");
            }
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
