package com.lzm.banco.bankline.service;

import com.lzm.banco.bankline.dto.NovaMovimentacao;
import com.lzm.banco.bankline.model.Correntista;
import com.lzm.banco.bankline.model.Movimentacao;
import com.lzm.banco.bankline.model.MovimentacaoTipo;
import com.lzm.banco.bankline.repository.CorrentistaRepository;
import com.lzm.banco.bankline.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MovimentacaoService {
    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private CorrentistaRepository correntistaRepository;

    public void save(NovaMovimentacao novaMovimentacao){
        Movimentacao movimentacao = new Movimentacao ();
        Double valor = novaMovimentacao.getTipo()== MovimentacaoTipo.RECEITA ? novaMovimentacao.getValor () : novaMovimentacao.getValor () * -1;
        /* --> Outra forma de usar essa lógica:
        Double valor = novaMovimentacao.getValor();
        if(novaMovimentacao.getTipo() == MovimentacaoTipo.DESPESA)
        valor = valor * -1;
        */

        movimentacao.setDataHora (LocalDateTime.now());
        movimentacao.setDescricao(novaMovimentacao.getDescricao ());
        movimentacao.setIdConta (novaMovimentacao.getIdConta ());
        movimentacao.setTipo(novaMovimentacao.getTipo());
        movimentacao.setValor(valor);

        Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);
        if(correntista !=null) {
            correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
            correntistaRepository.save(correntista);
        }

        repository.save(movimentacao);
    }
}
