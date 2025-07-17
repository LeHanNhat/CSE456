package vn.edu.eiu.lab3.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "School")
public class School {

    @Id
    @Column(name = "schoolId",columnDefinition = "CHAR(3)")
    private String schoolId;

    @Column(name = "schoolName",columnDefinition = "VARCHAR(100)",nullable = false)
    private String schoolName;

    @Column(name = "location" , columnDefinition = "VARCHAR(100)")
    private String location;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "school")
    private List<Major> majors = new ArrayList<>();
    public void addMajor(Major major){
        majors.add(major);
        major.setSchool(this);
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "school")
    private List<Student> students = new ArrayList<>();



    public void addStudent(Student student){
        students.add(student);
        student.setSchool(this);
    }



    public School(String schoolId, String schoolName, String location) {
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.location = location;
    }
}
