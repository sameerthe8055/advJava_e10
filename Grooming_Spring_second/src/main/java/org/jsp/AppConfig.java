package org.jsp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean
	public Mobile mobile1(){ // mobile1 is id
		Mobile mobile = new Mobile();
		mobile.setId(101);
		mobile.setModelName("Apple");
		mobile.setRam(6);
		mobile.setRom(12);
		return mobile;
	}
}
