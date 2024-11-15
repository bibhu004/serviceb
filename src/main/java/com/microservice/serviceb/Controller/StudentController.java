package com.microservice.serviceb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.serviceb.DTOs.StudentDTO;
import com.microservice.serviceb.Service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add/detail")
    public ResponseEntity<String> saveDetails(@RequestBody StudentDTO studentDTO){
      try{
            studentService.saveDetails(studentDTO);
        return ResponseEntity.ok("Student details added successfully");
      } catch(IllegalArgumentException e){
        return ResponseEntity.badRequest().body(e.getMessage());
      } catch (Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occured");
      }
    }

    @GetMapping("/{roll}")
    public ResponseEntity<?> getStudentDetail(@PathVariable Long roll) {
        try {
            return ResponseEntity.ok(studentService.getStudentDetail(roll));
        } catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
         catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occured");
        }
    }
    

   
    
}
