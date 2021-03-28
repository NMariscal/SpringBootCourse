package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// In this class we are going to have all of our resources for the API
@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    // We can find the bean Student service if we put that is a Component/ service
    private final StudentService studentService;

    // Auto enlazado = enlaza el componente (controller) con Student service
    // El autowired se pone en el constructor, atributo o meth. setter
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // ENDPOINT
    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

}
