package com.bookshop01.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


//
public class ViewNameInterceptor extends  HandlerInterceptorAdapter{
	
	
	
	//��ó�� �۾�
	//	controller�� ȣ��Ǳ� ���� �����ϴ� interceptor
	   @Override
	   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
		   
		   // HttpServletRequest�� ���ؼ� ���� ��û�� �� �̸��� ������ ��
		   
		   
		   try {
			   
		   // viewName�̶�� �̸����� ����
			String viewName = getViewName(request);
			System.out.println("�����viewName ���ͼ��� :" + viewName);
			
			// viewName �Ӽ��� ���� / 
			// ���� viewName�� ���� ������ ��� ������ �����͸� �����ϴ� �� ���ȴ�.
			request.setAttribute("viewName", viewName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		   
		   //���� ���� , ���� �Ѵ� true ��ȯ
		   return true;
	   }
	   
	   
	   
	   
	   
	   //��ó�� �۾�
	   
	   @Override
	   public void postHandle(HttpServletRequest request, HttpServletResponse response,
	                           Object handler, ModelAndView modelAndView) throws Exception {
	   }

	   
	   
	   
	   //HandlerInterceptor �������̽����� �����ϴ� �޼��� 
	   //��Ʈ�ѷ��� �ڵ鷯 �޼��尡 ��� ����� �� (�䰡 �������� ��) ȣ��
	   //�ַ� ���ҽ��� �����ϰų� �α�� ���� ������ �۾��� �����Ѵ�.
	   
	   //�޼��� ���� ���� ���⿡ ���ܰ� �߻��ص� Ŭ���̾�Ʈ���� ���޵��� �ʴ´�.
	   //�ַ� �α� ���� ���� �뵵
	   @Override
	   public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
	                                    Object handler, Exception ex)    throws  Exception {
	   }
	   
	   
	   
	   
	   
	   //HttpServletRequest���� ���� �� �̸��� �����ϴ� �޼���
	   private String getViewName(HttpServletRequest request) throws Exception {
		   
		   //HttpServletRequest���� ���ؽ�Ʈ ��� getContextPath�� �����´�.
			String contextPath = request.getContextPath();
			
			//"javax.servlet.include.request_uri" �Ӽ��� ���� ���� ��û��
			// URL�� �����´�.
			String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
			
			//���� ���ٸ� ���� request.getRequestURI�� ����Ѵ�.
			if (uri == null || uri.trim().equals("")) {
				uri = request.getRequestURI();
			}
			
			
			
			//���ؽ�Ʈ ����� ��带 ����ϴ� �κ�
			//��ΰ� null�̰ų� ��(" ")���ڿ��� �ƴ� ��쿡�� begin�� ���ؽ�Ʈ ����� �渮�� ���� 
			
			//���ؽ�Ʈ ��ΰ� �����ϸ� begin�� ���ؽ�Ʈ ����� ���̷� ����
			//���� ��ΰ� ������ begin�� ������ 0���� ����
			int begin = 0;
			if (!((contextPath == null) || ("".equals(contextPath)))) {
				begin = contextPath.length();
			}

			int end;
			if (uri.indexOf(";") != -1) {
				end = uri.indexOf(";");
			} else if (uri.indexOf("?") != -1) {
				end = uri.indexOf("?");
			} else {
				end = uri.length();
			}

			String fileName = uri.substring(begin, end);
			if (fileName.indexOf(".") != -1) {
				fileName = fileName.substring(0, fileName.lastIndexOf("."));
			}
			if (fileName.lastIndexOf("/") != -1) {
				fileName = fileName.substring(fileName.lastIndexOf("/",1), fileName.length());
			}
			return fileName;
		}
	}
