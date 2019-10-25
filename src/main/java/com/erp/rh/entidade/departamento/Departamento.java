/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erp.rh.entidade.departamento;

import com.erp.rh.entidade.funcionario.Funcionario;
import java.util.List;

/**
 *
 * @author Raul Portela
 */
public class Departamento {
    
    private Long id;
    
    private String Nome;
    
    private List<Funcionario> funcionarios;
}
