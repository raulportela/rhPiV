/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erp.rh.controller.home;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.erp.rh.repository.Suspensao.SuspensaoRepository;
import com.erp.rh.repository.advertencia.AdvertenciaRepository;
import com.erp.rh.repository.funcionario.FuncionarioRepository;

/**
 *
 * @author Luana
 */

@Controller
@RequestMapping("/erp")
public class HomeController {

	@Autowired
	SuspensaoRepository suspensaoRepository;

	@Autowired
	FuncionarioRepository funcionarioRepository;

	@Autowired
	AdvertenciaRepository advertenciaRepository;

	@GetMapping("/home")
	public ModelAndView home() {
		return new ModelAndView("/home/index");
	}

	
	@ModelAttribute("AllFuncionario")
	public int listaFuncionarios() {
		return funcionarioRepository.findAll().size();

	}

	@ModelAttribute("AllAdvertencias")
	public int listaAdvertencias() {
		return advertenciaRepository.findAll().size();

	}
	
	@ModelAttribute("AllSuspensao")
	public int listaSuspensao() {
		return suspensaoRepository.findAll().size();

	}
	
	@ModelAttribute("AllRecentes")
	public int listaNovosFuncionario() {
		
		
		return funcionarioRepository.findByDataAdmissaoBetween(LocalDate.now().plusDays(-5), LocalDate.now()).size();

	}
}
