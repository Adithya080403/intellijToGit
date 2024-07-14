package com.jbdl63.session8JDBC.Service;

import com.jbdl63.session8JDBC.Model.Student;
import com.jbdl63.session8JDBC.Repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@Slf4j
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public int creatNewStudent(Student student)
    {
        log.info("Student Body Received:",student.toString());
        return studentRepository.createNewStudent(student);
    }

    public List<Student> fetchAllStudents()
    {
        List<Student> studentList=studentRepository.fetchAllStudent();
        if(studentList.isEmpty())
        {
            log.error("No Student Exist");
             throw new RuntimeException("No student Exist");
        }
        return studentList;
    }

    public Student fetchStudentById(Integer id) {
        Student student=studentRepository.fetchStudentById(id);
        if(student== null)
        {
            log.error("No Student Exist");
            throw new RuntimeException("No student Exist");
        }
        return student;
    }

    public int creatNewStudentValue(Student student) {
        log.info("Student Body Received:",student.toString());
        return studentRepository.createNewStudentValue(student);
    }
}
