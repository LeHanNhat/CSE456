package vn.edu.eiu.lab2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Column(name = "Gpa",columnDefinition = "double")
    private double gpa;
    @Column(name = "Yob",columnDefinition = "int",nullable = false)
    private int yob;

    @Id
    @Column(name = "Id",columnDefinition = "bigint")
    private Long id;

    @Column(name = "Name",columnDefinition = "varchar(50)",nullable = false)
    private String name;
}
