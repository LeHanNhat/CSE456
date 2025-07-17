package vn.edu.eiu.lab3.service;

import vn.edu.eiu.lab3.entity.Major;
import vn.edu.eiu.lab3.entity.Student;
import vn.edu.eiu.lab3.repository.MajorRepo;

import java.util.List;

public class MajorService {
    public void addMajor(Major major) {
        MajorRepo.save(major);
    }
    public void removeMajor(Major major) {
        MajorRepo.remove(major);
    }
    public void updateMajor(Major major) {
        MajorRepo.update(major);
    }
    public List<Major> findMajorById(String id) {
        return MajorRepo.findMajorByMajorId(id);
    }
    public void assignedStudentToMajor(Major major, Student student) {
        MajorRepo.assignedStudentToMajor(major, student);
    }

}
