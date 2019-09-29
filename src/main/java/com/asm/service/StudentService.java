package com.asm.service;

import com.asm.entity.Student;
import com.asm.repository.AptechClassRepository;
import com.asm.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    AptechClassRepository aptechClassRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public Student getByEmail(String email) {
        return studentRepository.findByEmail(email).orElse(null);
    }

    public Student register(Student student) {
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        student.setCreatedAt(Calendar.getInstance().getTimeInMillis());
        student.setUpdatedAt(Calendar.getInstance().getTimeInMillis());
        student.setRole("student");
        student.setStatus(1);
        return studentRepository.save(student);
    }

    public Student login(String email, String password) {
        Optional<Student> optionalAccount = studentRepository.findByEmail(email);
        if (optionalAccount.isPresent()) {
            Student student = optionalAccount.get();
            if (student.getPassword().equals(password)) {
                return student;
            }
        }
        return null;
    }

}
