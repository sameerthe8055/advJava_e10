package org.jsp.controller;

import org.jsp.dao.MobileDao;
import org.jsp.dto.Mobile;

public class MobileController {
	public static void main(String[] args) {
//		Mobile mobile = new Mobile();
//		mobile.setId(104);
//		mobile.setBrandName("POKO");
//		mobile.setRam(6);
//		mobile.setRom(256);
//		mobile.setCost(5999);
		
		MobileDao dao = new MobileDao();
		
//		dao.save(mobile);
		
		dao.findAllMobiles();
		
		Mobile vokoMobile =  dao.findByBrandName("VOKO");
		vokoMobile.setCost(8999);
		dao.update(vokoMobile);
		
		dao.findAllMobiles();
		
//		System.out.println("Updating mobile iqoo started");		
////		dao.updateCost(102, 15000);
		
		dao.findAllMobiles();
		
		
		
		
		
		
	}

}
