package org.jsp.controller;

import org.jsp.dao.MobileDao;
import org.jsp.dto.Mobile;

public class MobileController {
	public static void main(String[] args) {
		Mobile mobile = new Mobile();
		mobile.setId(102);
		mobile.setBrandName("Iqoo");
		mobile.setRam(6);
		mobile.setRom(128);
		
		MobileDao dao = new MobileDao();
		
		dao.save(mobile);
	}

}
