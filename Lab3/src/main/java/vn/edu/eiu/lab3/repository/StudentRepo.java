package vn.edu.eiu.lab3.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import vn.edu.eiu.lab3.entity.Student;
import vn.edu.eiu.lab3.infra.JpaUtil;


import java.util.List;

public class StudentRepo {
    public static void save(Student student){
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();
    }

    public static void remove(Student student) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(student);
        em.getTransaction().commit();
        em.close();
    }
    public static void update(Student student) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
        em.close();
    }
    public static  Student findStudentById(String id) {
        EntityManager em = JpaUtil.getEntityManager();
        return em.find(Student.class, id);
    }
    public  static List<Student> findAllStudents() {
        EntityManager em = JpaUtil.getEntityManager();
        return em.createQuery("select s from Student s", Student.class).getResultList();
    }
    public static List<Student> findStudentsbyName(String name) {
        EntityManager em = JpaUtil.getEntityManager();
        Query p = em.createQuery("select s from Student s where s.fullName like :name", Student.class);
        p.setParameter("name" , "%" + name + "%");
        return p.getResultList();
    }
}
