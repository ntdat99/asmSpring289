package com.asm.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Vui lòng nhập mã sinh viên")
    @Size(min = 7, max = 7, message = "Mã sinh viên chỉ chứa 7 kí tự")
    private String rollNumber;
    @NotBlank(message = "Vui lòng nhập tên")
    private String name;
    @NotBlank(message = "Vui lòng nhập email")
    @Email(message = "Email không đúng định dạng")
    private String email;
    @NotBlank(message = "Vui lòng nhập mật khẩu")
    private String password;
    private String role;
    @ManyToMany(mappedBy = "studentSet",cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private Set<AptechClass> aptechClassSet;
    private long createdAt;
    private long updatedAt;
    private int status;

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<AptechClass> getAptechClassSet() {
        return aptechClassSet;
    }

    public void setAptechClassSet(Set<AptechClass> aptechClassSet) {
        this.aptechClassSet = aptechClassSet;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
