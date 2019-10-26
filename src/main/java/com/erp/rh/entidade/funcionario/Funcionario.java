/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erp.rh.entidade.funcionario;

import com.erp.rh.entidade.contato.Contato;
import com.erp.rh.entidade.advertencia.Advertencia;
import com.erp.rh.entidade.cargo.Cargo;
import com.erp.rh.entidade.endereco.Endereco;
import com.erp.rh.entidade.suspensao.Suspensao;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
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
    @Column(nullable = false, name = "GENRE")
    private boolean genre;
    
    @Column(length = 10, nullable = false, name = "SENHA")
    private String hashsenha;
    
    @Embedded
    @OneToOne
    private Endereco endereco;
    @Embedded
    @OneToOne
    private Contato contato;
    
    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "funcionario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Advertencia> advertencia;
    
    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "funcionario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Suspensao> suspensao;
    
    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "funcionario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Cargo> cargo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDtBirth() {
        return dtBirth;
    }

    public void setDtBirth(LocalDate dtBirth) {
        this.dtBirth = dtBirth;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public boolean isGenre() {
        return genre;
    }

    public void setGenre(boolean genre) {
        this.genre = genre;
    }

    public String getHashsenha() {
        return hashsenha;
    }

    public void setHashsenha(String hashsenha) {
        this.hashsenha = hashsenha;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public List<Advertencia> getAdvertencia() {
        return advertencia;
    }

    public void setAdvertencia(List<Advertencia> advertencia) {
        this.advertencia = advertencia;
    }

    public List<Suspensao> getSuspensao() {
        return suspensao;
    }

    public void setSuspensao(List<Suspensao> suspensao) {
        this.suspensao = suspensao;
    }

    public List<Cargo> getCargo() {
        return cargo;
    }

    public void setCargo(List<Cargo> cargo) {
        this.cargo = cargo;
    }
    
    
}
