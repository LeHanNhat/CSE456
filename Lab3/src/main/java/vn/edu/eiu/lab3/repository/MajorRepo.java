package vn.edu.eiu.lab3.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import vn.edu.eiu.lab3.entity.Major;
import vn.edu.eiu.lab3.entity.Student;
import vn.edu.eiu.lab3.infra.JpaUtil;

import java.util.List;

public class MajorRepo {
    public static void save(Major major){
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(major);
        em.getTransaction().commit();
        em.close();
    }

    public static void remove(Major major) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(major);
        em.getTransaction().commit();
        em.close();
    }
    public static void update(Major major) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(major);
        em.getTransaction().commit();
        em.close();
    }
    public static  Major findStudentById(String id) {
        EntityManager em = JpaUtil.getEntityManager();
        return em.find(Major.class, id);
    }

    public  static void assignedStudentToMajor(Major major, Student student) {
        major.addStudent(student);
    }
    public  static List<Major> findAllMajor() {
        EntityManager em = JpaUtil.getEntityManager();
        return em.createQuery("select s from Student s", Major.class).getResultList();
    }
    public static List<Major> findMajorByMajorId(String majorId) {
        EntityManager em = JpaUtil.getEntityManager();
        Query p = em.createQuery("select s from Major s where s.majorId like :majorId", Major.class);
        p.setParameter("majorId" , "%" + majorId + "%");
        return p.getResultList();
    }
}
