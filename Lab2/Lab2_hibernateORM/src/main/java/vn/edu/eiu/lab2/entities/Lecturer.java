package vn.edu.eiu.lab2.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "lecturer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lecturer {
    @Column(name = "Salary",columnDefinition = "double")
    private double salary;
    @Column(name = "Yob",columnDefinition = "int",nullable = false)
    private int yob;

    @Id
    @Column(name = "Id",columnDefinition = "bigint")
    private Long id;


    @Column(name = "Name",columnDefinition = "varchar(50)",nullable = false)
    private String name;


}
