package com.asm.controller;

import com.asm.entity.Student;
import com.asm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String showLoginPage() {
        return "login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/detail")
    public String showStudentDetail(Model model, Authentication authentication){
        model.addAttribute("student", studentService.getByEmail(authentication.getName()));
        return "detail";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public String createAccount(Model model) {
        model.addAttribute("student", new Student());
        return "form";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public String storeAccount(@Valid Student account, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        studentService.register(account);
        return "redirect:/students/login";
    }

}
