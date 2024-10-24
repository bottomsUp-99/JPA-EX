package main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpabasic.reserve.domain.User;

public class UserUpdateMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabegin");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            User user = em.find(User.class, "minji@newjins.com");
            if (user == null) {
                System.out.println("minji 없음");
            } else {
                String newName = "minji" + "변경함";
                user.changeName(newName);
                System.out.printf("minji가 팬사인회에 참석중입니다. email=%s, name=%s, createDate=%s\n", user.getEmail(), user.getName(), user.getCreateDate());
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
