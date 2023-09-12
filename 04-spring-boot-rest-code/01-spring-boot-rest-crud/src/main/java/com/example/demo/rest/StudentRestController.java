package com.example.demo.rest;

import com.example.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    // Def List of Student Object
    private List<Student> students;

    // Def @PostConstructor to load the students data... only once!
    @PostConstruct
    public void loadData() {
        this.students = new ArrayList<Student>();
        students.add( new Student("Poornima", "Patel"));
        students.add( new Student("Mario", "Rossi"));
        students.add( new Student("Mary", "Smith"));
    }

    // def endpoint for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return this.students;
    }

    // Def endpoint or "/students/{studentId}" - return student index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        // Index into the list

        if ((studentId >= this.students.size()) || (studentId < 0))
            throw new StudentNotFoundException("Student Id not found: " + studentId);
        return this.students.get(studentId);
    }

    // add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handlerException(StudentNotFoundException exc){
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}
