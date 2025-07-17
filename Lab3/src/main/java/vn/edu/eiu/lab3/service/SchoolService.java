package vn.edu.eiu.lab3.service;

import vn.edu.eiu.lab3.entity.Major;
import vn.edu.eiu.lab3.entity.School;
import vn.edu.eiu.lab3.entity.Student;
import vn.edu.eiu.lab3.repository.MajorRepo;
import vn.edu.eiu.lab3.repository.SchoolRepo;

import java.util.List;

public class SchoolService {
    public void addSchool(School school) {
        SchoolRepo.save(school);
    }
    public void removeSchool(School school) {
        SchoolRepo.remove(school);
    }
    public void updateSchool(School school) {
        SchoolRepo.update(school);
    }

    public void assignedStudentToSchool(School school,Student student) {
        SchoolRepo.assignedStudentToSchool(school,student);
    }

    public void assignedMajorToSchool(School school,Major major) {
        SchoolRepo.assignedMajor(school,major);
    }

}
