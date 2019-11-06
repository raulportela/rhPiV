/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erp.rh.controller.advertencia;

import com.erp.rh.entidade.advertencia.Advertencia;
import com.erp.rh.repository.advertencia.AdvertenciaRepository;
import com.erp.rh.repository.funcionario.FuncionarioRepository;
import java.time.LocalDate;
import javax.validation.Valid;
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
 * @author Raul
 */
@Controller
@RequestMapping("/erp/advertencia")
public class AdvertenciaController {

    @Autowired
    AdvertenciaRepository advertenciaRepository;

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("advertencia") @Valid Advertencia advertencia,
            RedirectAttributes redirectAttributes) {
        advertenciaRepository.save(advertencia);
        return new ModelAndView("redirect:/erp/funcionario/listar");

    }

//    @GetMapping("/buscar/{id}")
//    public ModelAndView funcinarioById(@PathVariable(value = "id") long id) {
//        Funcionario alterarfunc = funcionarioRepository.findById(id);
//        return new ModelAndView("/funcionario/cadastrarAlterar").addObject("funcionario", alterarfunc);
//    }
    
    @GetMapping("/aplicar/{id}")
    public ModelAndView advertir(@PathVariable(value = "id") long id){

        Advertencia advertencia = new Advertencia();

        advertencia.setDtAplicacao(LocalDate.now());
        advertencia.setFuncionario(funcionarioRepository.findById(id));

        return new ModelAndView("/advertencia/advertencia")
                .addObject("advertencia", advertencia);
    }

}
