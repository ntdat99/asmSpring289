package com.asm.controller;

import com.asm.service.AptechClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/aptech/clazz")
public class AptechClassController {

    @Autowired
    AptechClassService aptechClassService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("list", aptechClassService.getList());
        return "clazz/list";
    }
}
