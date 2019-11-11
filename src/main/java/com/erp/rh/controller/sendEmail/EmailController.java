package com.erp.rh.controller.sendEmail;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/erp/email")
public class EmailController {

	@Autowired
	private JavaMailSender javaMailSender;

	@GetMapping("enviar")
	public ModelAndView sendEmail(RedirectAttributes redirectAttributes) {

		try {
			MimeMessage mail = javaMailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(mail);
			helper.setTo("jeferson_nls@hotmail.com");
			helper.setSubject("Assunto da msg, caga ponche");
			helper.setText("Digite a msg aqui, teste de msg salve.");
			javaMailSender.send(mail);

			redirectAttributes.addFlashAttribute("mensagemSucesso", "Email enviado com sucesso");
						
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("mensagemSucesso", "Erro ao enviar email");
			
		}
		
		return new ModelAndView("redirect:/erp/funcionario/listar");

	}
//	Fonte 
//	https://receitasdecodigo.com.br/spring-boot/como-configurar-projetos-spring-boot-para-enviar-e-mail
}
