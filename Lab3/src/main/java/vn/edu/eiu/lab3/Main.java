package vn.edu.eiu.lab3;

import jakarta.persistence.EntityManager;
import vn.edu.eiu.lab3.entity.Gender;
import vn.edu.eiu.lab3.entity.Major;
import vn.edu.eiu.lab3.entity.School;
import vn.edu.eiu.lab3.entity.Student;
import vn.edu.eiu.lab3.infra.JpaUtil;
import vn.edu.eiu.lab3.service.MajorService;
import vn.edu.eiu.lab3.service.SchoolService;
import vn.edu.eiu.lab3.service.StudentService;


import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SchoolService schoolService = new SchoolService();
        MajorService majorService = new MajorService();
        StudentService studentService = new StudentService();



        School eiu = new School("EIU", "Eastern International University", "BD");


        Major cse456 = new Major("C456", "Advanced Java Programming");
        Major cse454 = new Major("C454", "Open-Source Software Design");

        Student st1 = new Student("Nhất Lê", Gender.MALE, LocalDate.parse("2003-06-06"), 3.2, 2021);
        Student st2 = new Student("Bảo Lê", Gender.MALE, LocalDate.parse("2002-10-25"), 3.5, 2020);
        Student st3 = new Student("Duy Nguyễn", Gender.MALE, LocalDate.parse("2002-08-25"), 3.3, 2020);
        Student st4 = new Student("Ngân Hồ",Gender.FEMALE, LocalDate.parse("2003-02-14"), 3.3, 2021);
        //CRUD
        schoolService.addSchool(eiu);
        majorService.addMajor(cse456);
        majorService.addMajor(cse454);
        studentService.addStudent(st1);
        studentService.addStudent(st2);
        studentService.addStudent(st3);
        studentService.addStudent(st4);
       

        studentService.findAllStudents().forEach(System.out::println);

//        schoolService.updateSchool(eiu);
//        majorService.updateMajor(cse456);
//        studentService.updateStudent(st1);
//
//        schoolService.removeSchool(eiu);
//        majorService.removeMajor(cse454);
//        studentService.removeStudent(st4);



        //Assign student to school



        schoolService.assignedStudentToSchool(eiu,st1);
        schoolService.assignedStudentToSchool(eiu,st2);
        schoolService.assignedStudentToSchool(eiu,st3);
        schoolService.assignedStudentToSchool(eiu,st4);
        //Assign majors to school
        schoolService.assignedMajorToSchool(eiu,cse456);
        schoolService.assignedMajorToSchool(eiu,cse454);






        //Assign students to major
        majorService.assignedStudentToMajor(cse456,st1);
        majorService.assignedStudentToMajor(cse456,st3);
        majorService.assignedStudentToMajor(cse454,st2);
        majorService.assignedStudentToMajor(cse454,st4);






    }
}