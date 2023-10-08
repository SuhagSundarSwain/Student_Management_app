package com.suhag_rest_api.suhag_rest_api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.suhag_rest_api.suhag_rest_api.Entities.LoginUser;
import com.suhag_rest_api.suhag_rest_api.Repository.LoginRepository;

@SpringBootTest
class SuhagRestApiApplicationTests {

	@Autowired
	LoginRepository loginRepository;

	@Test
	void contextLoads() {
		System.out.println("123"=="123");
	}

}
