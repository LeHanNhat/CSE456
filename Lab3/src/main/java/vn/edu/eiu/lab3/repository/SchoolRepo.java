package vn.edu.eiu.lab3.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import vn.edu.eiu.lab3.entity.Major;
import vn.edu.eiu.lab3.entity.School;
import vn.edu.eiu.lab3.entity.Student;
import vn.edu.eiu.lab3.infra.JpaUtil;

import java.util.List;

public class SchoolRepo {

        public static void save(School school){
            EntityManager em = JpaUtil.getEntityManager();
            em.getTransaction().begin();
            em.persist(school);
            em.getTransaction().commit();
            em.close();
        }

        public static void remove(School school) {
            EntityManager em = JpaUtil.getEntityManager();
            em.getTransaction().begin();
            em.remove(school);
            em.getTransaction().commit();
            em.close();
        }
        public static void update(School school) {
            EntityManager em = JpaUtil.getEntityManager();
            em.getTransaction().begin();
            em.merge(school);
            em.getTransaction().commit();
            em.close();
        }


        public  static void assignedMajor(School school, Major major) {
          school.addMajor(major);
        }
        public static void assignedStudentToSchool(School school, Student student) {
            school.addStudent(student);
        }



}
