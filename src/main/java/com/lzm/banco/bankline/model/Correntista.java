package com.lzm.banco.bankline.model;

import org.hibernate.annotations.Generated;

import javax.persistence.*;

@Entity
@Table(name="tab_correntista")
public class Correntista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length=20)
    private String cpf;

    @Column(length = 60)
    private String nome;

    @Embedded
    private Conta conta;

    public Conta getConta() {
        return conta;

    }
    public void setConta(Conta conta){
        this.conta = conta;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id; //aqui provavelemnte seja subsituido por um gerador de id
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
