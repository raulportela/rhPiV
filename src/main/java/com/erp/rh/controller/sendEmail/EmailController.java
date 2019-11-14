package com.erp.rh.controller.sendEmail;

import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@GetMapping("/funcionario/{id}")
	public ModelAndView msgPreDefinida(@PathVariable(value = "id") long id
			/*,@PathVariable(value = "true") boolean msg */) {
		Funcionario funcionario = funcionarioRepository.findById(id);
		Email emailDefinido = new Email();

//		if (msg == true) {
//			emailDefinido.setMensagem("Santo André, 07 de Dezembro de 2016.\r\n" + "\r\n" + "Quem possa interessar\r\n"
//					+ "\r\n" + "Declaramos para o devido fins que o Sr (a) " + funcionario.getFirstName() + " "
//					+ funcionario.getLastName() + ", portador do CPF " + funcionario.getCpf()
//					+ ",foi selecionado pelo RH desta Empresa para fazer parte de nosso quadro de funcionários a partir de "
//					+ funcionario.getDataAdmissao() + "\r\n" + "\r\n" + "\r\n" + "Sem mais,\r\n" + "\r\n" + "\r\n"
//					+ "\r\n" + "");
//		}

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
//	Fonte 
//	https://receitasdecodigo.com.br/spring-boot/como-configurar-projetos-spring-boot-para-enviar-e-mail
}
