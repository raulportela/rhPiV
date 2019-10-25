/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erp.rh.entidade.cargo;

import com.erp.rh.entidade.departamento.Departamento;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Raul Portela
 */
@Entity
public class Cargo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false, name = "NOME")
    private String nome;

    @Column(nullable = false, updatable = false, name = "DTSTART")
    private LocalDate dtStart;

    @Column(nullable = true, updatable = true, name = "DTEND")
    private LocalDate dtEnd;

    @Column(nullable = false, name = "SALARY")
    private Float salary;

    @OneToOne
    private Departamento departamento;

}
