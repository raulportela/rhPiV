/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erp.rh.repository.funcionario;

import com.erp.rh.entidade.funcionario.Funcionario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Raul Portela
 */
@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	
	
	Funcionario findById(long id);
	List<Funcionario> findAll();
	
	
	
	
	/**@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void save(Funcionario funcionario) {
		// Salvar cliente
		if (funcionario.getId() == null) {
			entityManager.persist(funcionario);
		} else {
			// Editar Cliente
			entityManager.merge(funcionario);
		}
	}

	@Transactional
	public Funcionario findById(Long id) {
		Query jpqlQyery = entityManager.createNamedQuery("Cliente.findById").setParameter("idFuncionario", id);
		Funcionario funcionario = (Funcionario) jpqlQyery.getSingleResult();
		return funcionario;
	}

	@Transactional
	public Funcionario findByEmail(String email) {
		Query jpqlQyery = entityManager.createNamedQuery("Funcionario.findByEmail").setParameter("email", email);
		Funcionario funcionario = (Funcionario) jpqlQyery.getSingleResult();
		return funcionario;
	}

	@Transactional
	public List<Funcionario> findAll() {
		Query jpqlQuery = entityManager.createNamedQuery("Funcionario.findAll");
		List<Funcionario> funcionarios = jpqlQuery.getResultList();
		return funcionarios;
	} */
}
