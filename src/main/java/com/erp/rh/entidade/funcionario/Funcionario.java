/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erp.rh.entidade.funcionario;

import com.erp.rh.entidade.cargo.Cargo;
import com.erp.rh.entidade.endereco.Endereco;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author Raul Portela
 */

@Entity
public class Funcionario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 30, nullable = false, name = "NOME")
    private String firstName;
    
    @Column(length = 50, nullable = false, name = "SOBRENOME")
    private String lastName;
    
    @Column(length = 11, nullable = false, name = "CPF")
    private Long cpf;
    
    @Column(nullable = false, updatable = false, name = "DTNASCIMENTO")
    private LocalDate dtBirth;
    
    @Column(nullable = false, name = "DISPONIVEL")
    private boolean disponivel;
    
    //true == female
    //false == male
    @Column(nullable = false, name = "DISPONIVEL")
    private boolean genre;
    
    @Column(length = 10, nullable = false, name = "SENHA")
    private String hashsenha;
    
    @OneToOne
    private Endereco endereco;
    
    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "funcionario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Cargo> cargo;
    
}
