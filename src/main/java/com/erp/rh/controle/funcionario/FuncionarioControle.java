/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erp.rh.controle.funcionario;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Luana
 */
@Controller
@RequestMapping("/erp")
public class FuncionarioControle {
    
    @GetMapping("/funcionarios")
    public ModelAndView listaFuncinarios(){
        return new ModelAndView("/funcionario/listarFuncionarios");
    }
    
    @GetMapping("/perfil")
    public ModelAndView Perfil(){
        return  new ModelAndView("/funcionario/profile");
    }
}

