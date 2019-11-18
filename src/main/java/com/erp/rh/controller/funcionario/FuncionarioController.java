/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erp.rh.controller.funcionario;

import com.erp.rh.entidade.advertencia.Advertencia;
import com.erp.rh.entidade.email.Email;
import com.erp.rh.entidade.funcionario.Funcionario;
import com.erp.rh.entidade.suspensao.Suspensao;
import com.erp.rh.repository.Suspensao.SuspensaoRepository;
import com.erp.rh.repository.advertencia.AdvertenciaRepository;
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
@RequestMapping("/erp/funcionario")
public class FuncionarioController {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Autowired
    AdvertenciaRepository advertenciaRepository;

    @Autowired
    SuspensaoRepository suspensaoRepository;

    @GetMapping("/listar")
    public ModelAndView listaFuncinarios() {

        List<Funcionario> funcionarios = new ArrayList<Funcionario>();

        for (Funcionario funcionario : funcionarioRepository.findAll()) {

            String porcentagem = String.valueOf(100 * funcionario.getDataAdmissao().getDayOfYear() / 345);
            funcionario.setFerias(porcentagem + "%");
            funcionarios.add(funcionario);

        }

        return new ModelAndView("/funcionario/listarFuncionarios")
                .addObject("listaFuncionario", funcionarios).addObject("email", new Email());
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("funcionario") @Valid Funcionario funcionario, BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("/funcionario/cadastrarAlterar");
        }

        if (funcionario.getId() == null) {
            funcionario.setDisponivel(true);
            funcionario.setDtAdmission(LocalDate.now());
            funcionarioRepository.save(funcionario);

            redirectAttributes.addFlashAttribute("mensagemSucesso",
                    "Funcionario " + funcionario.getFirstName() + " cadastrado com sucesso");
        } else {
            if (funcionario.getDataDemissao() == null) {
                funcionario.setDisponivel(true);

            } else {

                funcionario.setDisponivel(false);
            }

            redirectAttributes.addFlashAttribute("mensagemSucesso",
                    "Funcionario " + funcionario.getFirstName() + " Alterado com sucesso");
            funcionarioRepository.save(funcionario);
        }

        return new ModelAndView("redirect:/erp/funcionario/listar");

    }

    @GetMapping("/buscar/{id}")
    public ModelAndView funcinarioById(@PathVariable(value = "id") long id) {
        Funcionario alterarfunc = funcionarioRepository.findById(id);
        return new ModelAndView("/funcionario/cadastrarAlterar").addObject("funcionario", alterarfunc);
    }

    @GetMapping("/perfil/{id}")
    public ModelAndView perfil(@PathVariable(value = "id") long id) {
        Funcionario funcionario = funcionarioRepository.findById(id);

        List<Advertencia> advertencias = funcionario.getAdvertencias();
        List<Suspensao> suspensoes = funcionario.getSuspensao();
        return new ModelAndView("/funcionario/profile")
                .addObject("funcionario", funcionario)
                .addObject("advertencias", advertencias)
                .addObject("suspensoes", suspensoes);
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        return new ModelAndView("/funcionario/cadastrarAlterar").addObject("funcionario", new Funcionario());
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
