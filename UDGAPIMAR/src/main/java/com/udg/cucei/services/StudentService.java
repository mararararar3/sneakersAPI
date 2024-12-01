package com.udg.cucei.services;

import com.udg.cucei.models.StudentModel;
import com.udg.cucei.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<StudentModel> getAllStudents(){
        return (List<StudentModel>) studentRepository.findAll();
    }

    public StudentModel saveStudent(StudentModel studentModel){
        return studentRepository.save(studentModel);
    }

    public Optional<StudentModel> findStudentByCode(String code){
        return studentRepository.findByCode(code);
    }
    public Optional<StudentModel> findStudentByEmail(String email){
        return studentRepository.findByEmail(email);
    }

    public Optional<List<StudentModel>> findStudentByName(String name){
        return studentRepository.findByName(name);
    }


    public String deleteStudentByCode(String code){
        String response = "";

        Optional<StudentModel> foundStudent = findStudentByCode(code);
        if(foundStudent.isPresent()){
            studentRepository.delete(foundStudent.get());
            response = "Student deleted successfully";
        }else {
            response = "Student not found";
        }

        return response;
    }


    public StudentModel updateStudentByCode(String code, StudentModel studentModel){
        return findStudentByCode(code).isPresent() ? studentRepository.save(studentModel) : new StudentModel(0L,"Student not found","","",00d,"");
    }
}
