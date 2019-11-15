/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erp.rh.service;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.erp.rh.entidade.funcionario.Funcionario;
import com.erp.rh.repository.funcionario.FuncionarioRepository;

/**
 *
 * @author jrl
 */
@Service
public class UsuarioSistemaService implements UserDetailsService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public Funcionario loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Funcionario f = funcionarioRepository.findByLastName(username);
        if (f != null) {
            return f;
        }
        throw new UsernameNotFoundException("Usuário não encontrado");
    }

}
