package vn.edu.eiu.lab1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import vn.edu.eiu.lab1.entities.Course;
import vn.edu.eiu.lab1.entities.Student;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        Student john = new Student("1","John","Cena",2000,3.6);
        Course java = new Course("1","Java",4,4);
        System.out.println("Regular output");
        System.out.println(john);
        System.out.println(java+"\n");
        System.out.println("Json output");
        ObjectMapper objectMapper = new ObjectMapper();

        String student = objectMapper.writeValueAsString(john);
        String course = objectMapper.writeValueAsString(java);
        System.out.println(student);
        System.out.println(course+"\n");



    }
}