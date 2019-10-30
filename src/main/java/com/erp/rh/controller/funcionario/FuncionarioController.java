/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erp.rh.controller.funcionario;

import com.erp.rh.entidade.funcionario.Funcionario;
import com.erp.rh.repository.funcionario.FuncionarioRepository;
import org.springframework.stereotype.Controller;
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

        FuncionarioRepository funcionarioRepository;
    
	@GetMapping("/listar")
	public ModelAndView listaFuncinarios() {
		return new ModelAndView("/funcionario/listarFuncionarios");
	}

	@GetMapping("/perfil")
	public ModelAndView Perfil() {
		return new ModelAndView("/funcionario/profile");
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView Cadastrar() {
		return new ModelAndView("/funcionario/cadastrar")
                        .addObject("funcionario", new Funcionario());
	}
        
        @PostMapping("/save")
	public void Save(
                @ModelAttribute("funcionario") Funcionario funcionario,
                @RequestParam("dia") String dia,
                @RequestParam("mes") String mes,
                @RequestParam("ano") String ano,
                
                RedirectAttributes redirectAttributes) {
            funcionarioRepository.save(funcionario);
	}
}
