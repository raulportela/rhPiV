/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erp.rh.contato;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Raul Portela
 */
@Entity
public class Contato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false, name = "EMAIL")
    private String email;
    
    @OneToMany
    @Column(length = 15, nullable = false, name = "CELULARES")
    private List<String> celulares = new ArrayList<>();
    
    @OneToMany
    @Column(length = 15, nullable = false, name = "TELEFONES")
    private List<String> telefones = new ArrayList<>();
}
