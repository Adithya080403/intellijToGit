package com.jbdl63.session8JDBC.Controller;

import com.jbdl63.session8JDBC.Model.Student;
import com.jbdl63.session8JDBC.Service.StudentService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.reflect.CatchClauseSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.lang.*;
import java.util.*;

@RestController
@RequestMapping("/students")
@Slf4j
@Validated
public class StudentController
{
    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<String> addNewStudent(@Valid @RequestBody Student student)
    {
        if(studentService.creatNewStudent(student)==1)
        {
            return new ResponseEntity<>(String.format("New Student with Name : %s is Added",student.getStudName()), HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Insertion Failed",HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<List<Student>> fetchAllStudents()
    {
        try{
            return new ResponseEntity<>(studentService.fetchAllStudents(),HttpStatus.OK);
        }
        catch(RuntimeException e)
        {
            log.error("Exception occured: ",e.getMessage());
        }

        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> fetchStudentById(@PathVariable("id") Integer id)
    {
        try{
            return new ResponseEntity<>(studentService.fetchStudentById(id),HttpStatus.OK);
        }
        catch(RuntimeException e)
        {
            log.error("Exception occured: ",e.getMessage());
        }

        return null;
    }

    @PutMapping
    public ResponseEntity<String> addNewStudentValue(@RequestBody Student student)
    {
        if(studentService.creatNewStudentValue(student)==1)
        {
            return new ResponseEntity<>(String.format("New Student with Name : %s is Added",student.getStudName()), HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Insertion Failed",HttpStatus.BAD_REQUEST);
    }
}
