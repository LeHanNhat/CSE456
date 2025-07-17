package vn.edu.eiu.lab3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.edu.eiu.lab3.repository.SchoolRepo;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StudentId",columnDefinition = "INT")
    private long id;

    @Column(name = "fullName",columnDefinition = "VARCHAR(100)",nullable = false)
    private String fullName;

    @Column(name = "Gender",nullable = false)
    private Gender gender;

    @Column(name = "Dob",nullable = false)
    private LocalDate dob;

    @Column(name = "Gpa")
    private double gpa;

    @ManyToOne
    @JoinColumn(name = "MajorId")
    private Major major;
    @ManyToOne
    @JoinColumn(name = "SchoolId")
    private School school;

    @Column(name = "enrollmentYear",columnDefinition = "INT",nullable = false)
    private int enrollmentYear;

    public Student(String fullName, Gender gender, LocalDate dob, double gpa, int enrollmentYear) {
        this.fullName = fullName;
        this.gender = gender;
        this.dob = dob;
        this.gpa = gpa;
        this.enrollmentYear = enrollmentYear;
    }
}
