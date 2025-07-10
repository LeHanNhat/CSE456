package vn.edu.eiu.lab2.entities;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "subject")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {

    @Id
    @Column(name = "Code")
    private String code;

    @Column(name = "Name",columnDefinition = "varchar(50)",nullable = false)
    private String name;

    @Column(name = "Description",columnDefinition = "varchar(255)")
    private String description;
    @Column(name = "Credits",columnDefinition = "int",nullable = false)

    private int credits;
    @Column(name = "StudyHours",columnDefinition = "int",nullable = false)
    private int studyHours;


}
