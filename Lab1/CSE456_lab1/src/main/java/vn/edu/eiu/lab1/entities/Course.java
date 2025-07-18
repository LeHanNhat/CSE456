package vn.edu.eiu.lab1.entities;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Course {
    private String idCourse;
    private String name;
    private int credits;
    private double hours;
}