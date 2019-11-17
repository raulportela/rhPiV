/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erp.rh.entidade.funcionario;

import com.erp.rh.entidade.contato.Contato;
import com.erp.rh.entidade.acesso.Acesso;
import com.erp.rh.entidade.advertencia.Advertencia;
import com.erp.rh.entidade.endereco.Endereco;
import com.erp.rh.entidade.suspensao.Suspensao;
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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Raul Portela
 */
@Entity
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank(message = "Digite o nome")
    @Column(length = 30, nullable = false, name = "NOME")
    private String firstName;

    @NotNull
    @NotBlank(message = "Digite o sobrenome")
    @Column(length = 50, nullable = false, name = "SOBRENOME")
    private String lastName;

    @NotNull(message = "Digite o CPF")
    @Column(length = 11, nullable = false, name = "CPF")
    private Long cpf;

    @NotNull(message = "Digite a data de nascimento")
    @Column(nullable = false, updatable = false, name = "DTBIRTH")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dtBirth;

    @Column(nullable = false, updatable = false, name = "DTADMISSION")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dtAdmission;

    @Column(nullable = false, updatable = true, name = "DISPONIVEL")
    private boolean disponivel;

    // true == female
    // false == male
    @Column(nullable = false, name = "GENERO")
    private boolean genero;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Endereco endereco;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Contato contato;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Acesso acesso;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "funcionario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Advertencia> advertencias;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "funcionario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Suspensao> suspensao;

    @Column(length = 20, nullable = true, name = "DEPARTAMENTO")
    private String departamento;

    @Column(length = 50, nullable = true, name = "CARGO")
    private String cargo;

    @Column(nullable = false, updatable = true, name = "DATAADMISSAO")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataAdmissao;

    @Column(nullable = true, updatable = true, name = "DATADEMISSAO")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataDemissao;

//    @Fetch(FetchMode.SUBSELECT)
//    @OneToMany(mappedBy = "funcionario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private List<Cargo> cargo;
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

    public LocalDate getDtAdmission() {
        return dtAdmission;
    }

    public void setDtAdmission(LocalDate dtAdmission) {
        this.dtAdmission = dtAdmission;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public boolean isGenero() {
        return genero;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
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

    public Acesso getAcesso() {
        return acesso;
    }

    public void setAcesso(Acesso acesso) {
        this.acesso = acesso;
    }

    public List<Advertencia> getAdvertencias() {
        return advertencias;
    }

    public void setAdvertencias(List<Advertencia> advertencias) {
        this.advertencias = advertencias;
    }

    public List<Suspensao> getSuspensao() {
        return suspensao;
    }

    public void setSuspensao(List<Suspensao> suspensao) {
        this.suspensao = suspensao;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public LocalDate getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(LocalDate dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

}
