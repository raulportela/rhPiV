/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erp.rh.entidade.endereco;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Raul Portela
 */
@Entity
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false, name = "RUA")
    private String rua;

    @Column(length = 6, nullable = false, name = "NUMERO")
    private int numero;

    @Column(length = 50, nullable = false, name = "BAIRRO")
    private String bairro;

    @Column(length = 7, nullable = false, name = "CEP")
    private int cep;

    @Column(length = 200, nullable = false, name = "COMPLEMENTO")
    private String complemento;
}
