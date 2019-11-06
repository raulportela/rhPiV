/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erp.rh.entidade.advertencia;

import com.erp.rh.entidade.funcionario.Funcionario;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Raul Portela
 */
@Entity
public class Advertencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 240, nullable = false, name = "REASON")
    private String reason;

    @Column(nullable = false, name = "DTAPLICACAO")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dtAplicacao;

    @ManyToOne()
    private Funcionario funcionario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDate getDtAplicacao() {
        return dtAplicacao;
    }

    public void setDtAplicacao(LocalDate dtAplicacao) {
        this.dtAplicacao = dtAplicacao;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

}
