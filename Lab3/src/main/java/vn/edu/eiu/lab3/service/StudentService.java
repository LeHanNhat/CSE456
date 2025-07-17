package vn.edu.eiu.lab3.service;

import vn.edu.eiu.lab3.entity.Student;
import vn.edu.eiu.lab3.repository.StudentRepo;

import java.util.List;

public class StudentService {
    public void addStudent(Student student) {
        StudentRepo.save(student);
    }
    public void removeStudent(Student student) {
        StudentRepo.remove(student);
    }
    public void updateStudent(Student student) {
        StudentRepo.update(student);
    }
    public Student findStudentById(String id) {
        return StudentRepo.findStudentById(id);
    }
    public   List<Student> findAllStudents() {
        return StudentRepo.findAllStudents();
    }
    public  List<Student> findStudentsbyName(String name) {
        return StudentRepo.findStudentsbyName(name);
    }
}
