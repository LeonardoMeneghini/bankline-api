package com.lzm.banco.bankline.controller;

import com.lzm.banco.bankline.dto.NovoCorrentista;
import com.lzm.banco.bankline.model.Correntista;
import com.lzm.banco.bankline.repository.CorrentistaRepository;
import com.lzm.banco.bankline.service.CorrentistaService;
import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {
    @Autowired
    private CorrentistaRepository repository;
    @Autowired
    private CorrentistaService service;
    @GetMapping
    public List<Correntista> findAll(){
        return repository.findAll ();

    }
    @PostMapping
    public void save (@RequestBody NovoCorrentista correntista) {
        service.save(correntista);

    }

}