package com.asm.service;

import com.asm.entity.AptechClass;
import com.asm.repository.AptechClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AptechClassService {
    @Autowired
    AptechClassRepository aptechClassRepository;

    public List<AptechClass> getList() {
        return aptechClassRepository.findAll();
    }
}
