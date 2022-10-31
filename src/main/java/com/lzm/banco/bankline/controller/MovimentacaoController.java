package com.lzm.banco.bankline.controller;

import com.lzm.banco.bankline.dto.NovaMovimentacao;
import com.lzm.banco.bankline.dto.NovoCorrentista;
import com.lzm.banco.bankline.model.Correntista;
import com.lzm.banco.bankline.model.Movimentacao;
import com.lzm.banco.bankline.model.MovimentacaoTipo;
import com.lzm.banco.bankline.repository.CorrentistaRepository;
import com.lzm.banco.bankline.repository.MovimentacaoRepository;
import com.lzm.banco.bankline.service.CorrentistaService;
import com.lzm.banco.bankline.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {
    @Autowired
    private MovimentacaoRepository repository;
    @Autowired
    private MovimentacaoService service;
    @GetMapping
    public List<Movimentacao> findAll(){
        return repository.findAll ();

    }
    @PostMapping
    public void save (@RequestBody NovaMovimentacao movimentacao) {
        service.save(movimentacao);

    }

}