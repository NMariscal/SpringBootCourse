package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
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

    // POST = Add new resources to our system, in this case we are going to add a new student
    @PostMapping
    // we take the RequestBody and then we mapping into a Student
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    //DELETE
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);

    }

    //PUT: for update the name and the email.
    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable ("studentId") Long studentId,
                              @RequestParam(required=false) String name,
                              @RequestParam(required=false) String email) {
        studentService.updatestudent(studentId, name, email);

    }
}
