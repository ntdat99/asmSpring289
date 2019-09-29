package com.asm.config;

import com.asm.entity.Student;
import com.asm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailService implements UserDetailsService {
    @Autowired
    StudentService studentService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       Student student = studentService.getByEmail(email);
        if (student == null) {
            throw new UsernameNotFoundException("Không tìm thấy sinh viên nào");
        }
        return User.builder()
                .username(student.getEmail())
                .password(student.getPassword())
                .roles("student")
                .build();
    }
}
