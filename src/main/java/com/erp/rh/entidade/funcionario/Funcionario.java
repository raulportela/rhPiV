/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erp.rh.entidade.funcionario;

import com.erp.rh.entidade.cargo.Cargo;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Raul Portela
 */
public class Funcionario {
    
    private Long id;
    
    private String nome;
    
    private String sobrenome;
    
    private Long cpf;
    
    private LocalDate dtNascimento;
    
    private List<Cargo> cargo;
    
}
