package com.microservice.serviceb.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.serviceb.DTOs.StudentDTO;
import com.microservice.serviceb.Entity.Student;

@Service
public class StudentService {

    List<Student> allStudents = new ArrayList<>();

    public void saveDetails(StudentDTO studentDTO){
       
        
        if (allStudents.stream().anyMatch(student -> student.getRollNo().equals(studentDTO.getRollNo()))) {
            throw new IllegalArgumentException("Student with Roll " + studentDTO.getRollNo() + " already exists in the list.");
        }

        Student student = new Student();
        student.setId((long)allStudents.size()+1);
        student.setName(studentDTO.getName());
        student.setMark(studentDTO.getMark());
        student.setRollNo(studentDTO.getRollNo());
        
        allStudents.add(student);
    }

    public StudentDTO getStudentDetail(Long roll){
        Student student = allStudents.stream().filter(stud -> stud.getRollNo().equals(roll)).findAny()
        .orElseThrow(() -> new IllegalArgumentException ("Student Not found"));

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setRollNo(student.getRollNo());
        studentDTO.setName(student.getName());
        studentDTO.setMark(student.getMark());
        return studentDTO;
    }
    
}
