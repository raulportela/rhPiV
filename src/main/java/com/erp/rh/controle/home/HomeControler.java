/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erp.rh.controle.home;

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
public class HomeControler{
    
    @GetMapping("/home")
    public ModelAndView home (){
        return new ModelAndView ("/home/index");
    }
    
    
}
