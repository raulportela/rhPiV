package com.erp.rh;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.erp.rh.entidade.acesso.Acesso;
import com.erp.rh.repository.acesso.AcessoRepository;

@SpringBootTest
class ErpSenacApplicationTests {

	@Autowired
	AcessoRepository acessoRepossitory;

	@Test
	void contextLoads() {
		
		
	}

}
