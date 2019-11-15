/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erp.rh.repository.advertencia;

import com.erp.rh.entidade.advertencia.Advertencia;
import com.erp.rh.entidade.funcionario.Funcionario;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Raul Portela
 */
@Repository
public interface AdvertenciaRepository extends JpaRepository<Advertencia, Long> {

	Funcionario findById(long id);

	@Override
	List<Advertencia> findAll();

}
