/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erp.rh.controller.funcionario;

import com.erp.rh.entidade.funcionario.Funcionario;
import com.erp.rh.repository.funcionario.FuncionarioRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Luana
 */
@Controller
@RequestMapping("/erp/funcionario")
public class FuncionarioController {

	@Autowired
	FuncionarioRepository funcionarioRepository;

	@GetMapping("/listar")
	public ModelAndView listaFuncinarios() {
		List <Funcionario> listaFuncionario = new ArrayList();
		
		if(listaFuncionario.isEmpty()) {
			listaFuncionario = funcionarioRepository.findAll();
		}
		
		return new ModelAndView("/funcionario/listarFuncionarios").addObject("listaFuncionario", listaFuncionario);
	}

	@PostMapping("/save")
	public ModelAndView Save(@ModelAttribute("funcionario") @Valid Funcionario funcionario, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView("/funcionario/cadastrar");
		}
		funcionario.setDisponivel(true);
		funcionarioRepository.save(funcionario);
		redirectAttributes.addFlashAttribute("mensagemSucesso",
				"Funcinario " + funcionario.getFirstName() + " cadastrado com sucesso");
		return new ModelAndView("redirect:/erp/funcionario/listar");
	}

	@GetMapping("/perfil")
	public ModelAndView Perfil() {
		return new ModelAndView("/funcionario/profile");
	}

	@GetMapping("/cadastrar")
	public ModelAndView Cadastrar() {
		return new ModelAndView("/funcionario/cadastrar").addObject("funcionario", new Funcionario());
	}

}
