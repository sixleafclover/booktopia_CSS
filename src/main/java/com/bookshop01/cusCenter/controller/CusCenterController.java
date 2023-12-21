package com.bookshop01.cusCenter.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//∞Ì∞¥ºæ≈Õ
public interface CusCenterController {


	public ModelAndView orderIDInfo(@RequestParam("member_id") String order_id, HttpServletRequest request, HttpServletResponse response)  throws Exception; 
	

	

}
