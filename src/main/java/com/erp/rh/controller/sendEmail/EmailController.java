package com.erp.rh.controller.sendEmail;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.erp.rh.entidade.email.Email;
import com.erp.rh.entidade.funcionario.Funcionario;
import com.erp.rh.repository.funcionario.FuncionarioRepository;

@Controller
@RequestMapping("/erp/email")
public class EmailController {

    @Autowired
    FuncionarioRepository funcionarioRepository;
    @Autowired
    private JavaMailSender javaMailSender;

    @GetMapping("/novo")
    public ModelAndView novoEmail() {
        return new ModelAndView("/email/email").addObject("email", new Email());
    }

    @GetMapping("/departamento/{par}")
    public ModelAndView departamento(@PathVariable(value = "par") int par) {
        if(par == 1){
            
        }
        return new ModelAndView("/email/email").addObject("email", new Email());
    }

    @GetMapping("/promocao/{id}")
    public ModelAndView msgPromocao(@PathVariable(value = "id") long id
    /* ,@PathVariable(value = "true") boolean msg */) {

        Funcionario funcionario = funcionarioRepository.findById(id);
        Email emailDefinido = new Email();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String admisao = funcionario.getDtAdmission().format(formatter);

        emailDefinido.setMensagem("PROMOÇÃO\r\n" + "\r\n" + "Sr(a). " + funcionario.getFirstName() + " "
                + funcionario.getLastName() + "\r\n" + "\r\n"
                + "Temos o prazer de lhe comunicar que a partir do dia “inserir data” vossa senhoria passará a exercer o cargo de “informar cargo”.\r\n"
                + "\r\n"
                + "Estamos certos que você terá sucesso em sua nova função, a qual esperamos que seja exercida com a mesma dedicação e eficiência que \r\n"
                + "possibilitou a realização desta promoção.\r\n" + "\r\n"
                + "Receba nossos sinceros cumprimentos pela sua ascensão profissional.\r\n" + "\r\n"
                + "Cordialmente,\r\n" + "\r\n" + "Recursos Humanos.");

        return new ModelAndView("/email/email").addObject("email", emailDefinido);
    }

    @GetMapping("/funcionario/{id}")
    public ModelAndView msgPreDefinida(@PathVariable(value = "id") long id
    /* ,@PathVariable(value = "true") boolean msg */) {

        Funcionario funcionario = funcionarioRepository.findById(id);
        Email emailDefinido = new Email();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String admisao = funcionario.getDtAdmission().format(formatter);

        emailDefinido.setAssunto("CONTRATAÇÃO DE FUNCIONARIO");

        emailDefinido.setMensagem("CONTRATAÇÃO\r\n" + "\r\n" + "Informamos que o Sr (a) " + funcionario.getFirstName()
                + " " + funcionario.getLastName() + ", portador do CPF " + funcionario.getCpf() + ",\r\n"
                + "foi selecionada para ocupar o cargo de " + funcionario.getCargo() + " a partir de " + admisao
                + ". \r\n"
                + "Favor (se necessário) solicitar a aquisição dos equipamentos necessários para o novo colaborador exercer suas funções.\r\n"
                + "\r\n" + "Atenciosamente,\r\n" + "\r\n" + "Recursos Humanos");

        return new ModelAndView("/email/email").addObject("email", emailDefinido);
    }

    @PostMapping("enviar")
    public ModelAndView sendEmail(@ModelAttribute("email") @Valid Email email, RedirectAttributes redirectAttributes) {

        try {
            MimeMessage mail = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(mail);
            helper.setTo(email.getDestinatario());
            helper.setSubject(email.getAssunto());
            helper.setText(email.getMensagem());
            javaMailSender.send(mail);

            redirectAttributes.addFlashAttribute("mensagemSucesso", "Email enviado com sucesso");

        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("mensagemSucesso", "Erro ao enviar email");

        }

        return new ModelAndView("redirect:/erp/funcionario/listar");

    }

    @GetMapping("/contato/{id}")
    public ModelAndView msgEmailProfile(@PathVariable(value = "id") long id
    /* ,@PathVariable(value = "true") boolean msg */) {

        Funcionario funcionario = funcionarioRepository.findById(id);
        Email emailDefinido = new Email();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String admisao = funcionario.getDtAdmission().format(formatter);

        emailDefinido.setDestinatario(funcionario.getContato().getEmail());
        emailDefinido.setAssunto("EMAIL DE CONTATO Funcionario " + funcionario.getFirstName());

        return new ModelAndView("/email/email").addObject("email", emailDefinido);
    }

//	Fonte 
//	https://receitasdecodigo.com.br/spring-boot/como-configurar-projetos-spring-boot-para-enviar-e-mail
}
