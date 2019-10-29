/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erp.rh.entidade.cargo;

import com.erp.rh.entidade.departamento.Departamento;
import com.erp.rh.entidade.funcionario.Funcionario;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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

	@Embedded
	@OneToOne
	private Departamento departamento;

	@ManyToOne()
	private Funcionario funcionario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDtStart() {
		return dtStart;
	}

	public void setDtStart(LocalDate dtStart) {
		this.dtStart = dtStart;
	}

	public LocalDate getDtEnd() {
		return dtEnd;
	}

	public void setDtEnd(LocalDate dtEnd) {
		this.dtEnd = dtEnd;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

}
