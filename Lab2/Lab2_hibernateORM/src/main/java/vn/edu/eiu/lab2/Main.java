package vn.edu.eiu.lab2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import vn.edu.eiu.lab2.entities.Student;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab2_hibernate");
    public static void main(String[] args) {
//      insertStudent();
//      getAllStudent();
      //  findStudentByGPA("Le",3.5);
//      updateStudentGPA(2025004L,2.0);
//      updateStudentName(2025004L,"Tu");
      //  deleteStudentById(2025004L);
    }
    public static void updateStudentName(long id,String name) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Student student = em.find(Student.class, id);
        student.setName(name);
        em.persist(student);
        em.getTransaction().commit();
        em.close();
    }
    public static void insertStudent() {
        EntityManager em = emf.createEntityManager();
        Student student = new Student(3.2,2000, 2025001L,"Lan Le");
        Student student2 = new Student(3.2,2003, 2025002L,"Nhat Le");
        Student student3 = new Student(3.9,2002, 2025003L,"Duy Nguyen");
        Student student4 = new Student(3.1,2002, 2025004L,"Huy Tran");
        em.getTransaction().begin();
//        em.persist(student2);
        em.persist(student3);
        em.persist(student4); // ghi xuong database
        em.getTransaction().commit();
        em.close();
    }
    public static Student getStudentById(long id) {
        EntityManager em = emf.createEntityManager();
        Student student = em.find(Student.class, id);;
        em.close();
        return student;
    }
    public static void findStudentByGPA(String name,double gpa) {
        EntityManager em = emf.createEntityManager();
        List<Student> students = em.createQuery(
                        "SELECT s FROM Student s WHERE s.name LIKE :kw and s.gpa >= :gpa", Student.class)
                .setParameter("kw", "%" + name + "%")
                .setParameter("gpa", gpa)
                .getResultList();
        System.out.println("Students found: " + students.size());
        students.forEach(System.out::println);
        em.close();
    }
    public static void findStudentByName(String name) {
        EntityManager em = emf.createEntityManager();
        List<Student> students = em.createQuery("select s from Student s where s.name >= :name ", Student.class).setParameter("name",name).getResultList();
        System.out.println("Students found: " + students.size());
        students.forEach(System.out::println);
        em.close();
    }
    public static void getAllStudent() {
        EntityManager em = emf.createEntityManager();
        List<Student> students = em.createQuery("select s from Student s", Student.class).getResultList();
        em.close();
        System.out.println("The list of students: ");
        for (Student student : students) {
            System.out.println(student);
        }

    }
    public static void deleteStudentById(long id) {
        EntityManager em = emf.createEntityManager();
        Student student = em.find(Student.class, id);
        em.getTransaction().begin();
        em.remove(student);
        em.getTransaction().commit();
        em.close();
    }
    public static void updateStudentGPA(long id , double gpa) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Student student = em.find(Student.class, id);
        student.setGpa(gpa);
        em.persist(student);
        em.getTransaction().commit();
        em.close();
    }
}