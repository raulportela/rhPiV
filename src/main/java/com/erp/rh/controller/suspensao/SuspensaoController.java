/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erp.rh.controller.suspensao;

import com.erp.rh.entidade.funcionario.Funcionario;
import com.erp.rh.entidade.suspensao.Suspensao;
import com.erp.rh.repository.Suspensao.SuspensaoRepository;
import com.erp.rh.repository.funcionario.FuncionarioRepository;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Luana
 */
@Controller
@RequestMapping("/erp/suspensao")
public class SuspensaoController {
    
    @Autowired
    SuspensaoRepository suspensaoRepository;

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("suspensao") Suspensao suspensao,
            RedirectAttributes redirectAttributes) {
        long id = suspensao.getFuncionario().getId();
        Funcionario funcionario = funcionarioRepository.findById(id);
        suspensao.setFuncionario(funcionario);
        suspensaoRepository.save(suspensao);
        return new ModelAndView("redirect:/erp/funcionario/listar");

    }

    @GetMapping("/aplicar/{id}")
    public ModelAndView advertir(@PathVariable(value = "id") long id){

        Suspensao suspensao = new Suspensao();

        suspensao.setDtAplicacao(LocalDate.now());
        suspensao.setFuncionario(funcionarioRepository.findById(id));

        return new ModelAndView("/suspensao/suspensao")
                .addObject("suspensao", suspensao);
    }
}
