/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erp.rh.entidade.cargo;

import com.erp.rh.entidade.departamento.Departamento;
import java.time.LocalDate;

/**
 *
 * @author Raul Portela
 */
public class Cargo {

    private Long id;

    private String nome;

    private Departamento departamento;

    private LocalDate dtInicio;

    private LocalDate dtFim;

    private Float Salario ;
    
}
