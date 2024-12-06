package com.example.restapi.service;

import com.example.restapi.entity.Student;
import com.example.restapi.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // In StudentService.java
    @Transactional
    public Student updateStudent(Long id, Student updatedStudent) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Student not found"));
        student.setName(updatedStudent.getName()); // or update other fields
        student.setEmail(updatedStudent.getEmail());   // Add fields as needed
        return studentRepository.save(student);    // No need for merge, save handles it
    }


    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
