package com.udg.cucei.controllers;

import com.udg.cucei.models.StudentModel;
import com.udg.cucei.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
@CrossOrigin
public class StudentController {

    @Autowired
    StudentService studentService;


    @GetMapping("") //localhost:8080/students
    public List<StudentModel> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("") //localhost:8080/students
    public StudentModel saveStudent(@RequestBody StudentModel studentModel) {
        return studentService.saveStudent(studentModel);
    }


    @GetMapping("/findByCode={code}")
    public Optional<StudentModel> getStudentByCode(@PathVariable String code) {
        return studentService.findStudentByCode(code);
    }

    @GetMapping("/findByEmail={email}")
    public Optional<StudentModel> getStudentByEmail(@PathVariable String email) {
        return studentService.findStudentByEmail(email);
    }

    @GetMapping("/findByName={name}")
    public Optional<List<StudentModel>> getStudentByName(@PathVariable String name) {
        return studentService.findStudentByName(name);
    }


    @DeleteMapping("/deleteStudentByCode={code}")
    public String deleteStudentByCode(@PathVariable String code) {
        return studentService.deleteStudentByCode(code);
    }

    @PutMapping("")
    public StudentModel updateStudent(@RequestBody StudentModel studentModel) {
        return studentService.saveStudent(studentModel);
    }

    @PutMapping("/updateStudentByCode={code}")
    public StudentModel updateStudent(@PathVariable String code,@RequestBody StudentModel studentModel) {
        return studentService.updateStudentByCode(code,studentModel);
    }
}
