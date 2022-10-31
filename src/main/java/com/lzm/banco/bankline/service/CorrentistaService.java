package com.lzm.banco.bankline.service;

import com.lzm.banco.bankline.dto.NovoCorrentista;
import com.lzm.banco.bankline.model.Conta;
import com.lzm.banco.bankline.model.Correntista;
import com.lzm.banco.bankline.repository.CorrentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CorrentistaService {
    @Autowired
    private CorrentistaRepository repository;
    public void save (NovoCorrentista novoCorrentista) {
        Correntista correntista = new Correntista ();
        correntista.setCpf(novoCorrentista.getCpf ());
        correntista.setNome(novoCorrentista.getNome ());

        Conta conta = new Conta();
        conta.setSaldo(0.0);
        conta.setNumero(new Date ().getTime());

        correntista.setConta(conta);
        repository.save(correntista);
    }
}
