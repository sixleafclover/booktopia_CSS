package com.bookshop01.cusCenter.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookshop01.common.base.BaseController;
import com.bookshop01.member.vo.MemberVO;

@Controller("cusCenterController")
@RequestMapping(value="/center")
public class CusCenterControllerImpl extends BaseController implements CusCenterController{
	
	
	@Autowired
	private MemberVO memberVO;
	
	
	@RequestMapping(value="/centerMain.do" ,method = RequestMethod.POST)
	public ModelAndView orderIDInfo(@RequestParam("member_id") String order_id,
            HttpServletRequest request, HttpServletResponse response)  throws Exception{
		
		String viewName=(String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		HttpSession session=request.getSession();
		MemberVO memberVO=(MemberVO)session.getAttribute("memberInfo");

		String member_id=memberVO.getMember_id();
		
		System.out.println("고객센터 접속 ");

				
		return mav;
	}



	

}
