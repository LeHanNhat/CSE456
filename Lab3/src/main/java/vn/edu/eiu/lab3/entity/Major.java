package vn.edu.eiu.lab3.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "Major")
public class Major {


    @Id
    @Column(name = "majorId",columnDefinition = "VARCHAR(4)")
    private String majorId;

    @Column(name = "majorName",columnDefinition = "VARCHAR(100)")
    private String majorName;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "major")
    private List<Student> students = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "SchoolId")
    private School school;


    public void addStudent(Student student){
        students.add(student);
        student.setMajor(this);
    }

    public Major(String majorId, String majorName) {
        this.majorId = majorId;
        this.majorName = majorName;
    }
}
