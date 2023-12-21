package com.bookshop01.admin.goods.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;



//������ ���� ���� ��Ʈ�ѷ�
public interface AdminGoodsController {
	
	
	//ModelAndView ��ȯ Ÿ���� ������ �ִ� adminGoodsMain �߻� �޼���
	//������ ������������ ������ �����Ѵ�.
	
	//@RequestParam �� ��û�� �Ķ���͸� �޼����� �Ű������� ���ε�
	//Map<String, String> dateMap   Http �Ķ���͸� �����ϴ� �� / dataMap �̶�� �̸����� ���� �޾ƿ��� ��
	//Http �Ķ������ ���� �̸��� �������� ���ϴ� ��� ��� Map
 	public ModelAndView adminGoodsMain(@RequestParam Map<String, String> dateMap,HttpServletRequest request, HttpServletResponse response)  throws Exception;
	
	
	
	
	//ResponseEntity ��ȯ Ÿ���� ������ �ִ� addNewGoods �߻�޼���
	//������ ���ο� ���� �߰� ����� �����Ѵ�.
	
	//ResponseEntity - Spring Framework���� ����ϴ� http ������ ��Ÿ���� Ŭ���� / ������ Ŀ���͸���¡(������ ���� �ڵ�, ���, ���� �� ����) �� �� �ִ�.
	//MultipartHttpServletRequest ��Ƽ��Ʈ ��û ó�� / ���� ���ε�� ���� ���� ������ �����͸� ������ �� ����Ѵ�.
	public ResponseEntity addNewGoods(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)  throws Exception;
	
	
	
	
	//ResponseEntity ��ȯ Ÿ���� ������ �ִ� modifyGoodsInfo(��ǰ ����) �߻� �޼���
	//��ǰ�� ���� ���� ������ �����Ѵ�.	
	public ResponseEntity modifyGoodsInfo( 
			
								//@RequestParam Http ��û�� �Ķ���ͷ� �޾ƿ´�.
								//Ư���� �Ķ���͸��� ��������� �޾ƿ;��ϴ� ���
								// http ��û���� "goods_id" ��� �̸��� �Ķ���͸� ������ �� ������ �Ҵ� 
								// goods_id ������
								 @RequestParam("goods_id") String goods_id,
                                 @RequestParam("mod_type") String mod_type,
                                 @RequestParam("value") String value,
			                     HttpServletRequest request, HttpServletResponse response)  throws Exception;
	
	
	
	
	
//	-----------------------------------------------------------------------------------------------
	// ��ȯ Ÿ���� void�� ���
	// ��� ������ �����Ѵٰ� �ؼ� Ŭ���̾�Ʈ���� �װ��� �˷��ִ� ������ ������ �ʴ´�.
	// ��κ� ������ ���̽� ���� ������ ���� void ��ȯ Ÿ���� ����Ѵ�.
	
	// void = Ŭ���̾�Ʈ���� �˷��� ���� ����
	// ResponseEntity = Ŭ���̾�Ʈ���� �˷��� ���� ����
	
	
	
	//��ȯ Ÿ���� ���� ���� �̹��� ���� ���� �߻�޼���
	
	public void  removeGoodsImage(
			
			//@RequestParam("goods_id") int goods_id 
			//- Ư���� ���� ���̵� ���� ��������� �޾ƿ;��Ѵ�.(������ �̹����� �����Ǿ���ϱ� ����) 
			@RequestParam("goods_id") int goods_id,
			
			//- ���� ���� Ư���� ���� �̹����� ���� ��������� �޾ƿ;��Ѵ�.
            @RequestParam("image_id") int image_id,
            
            // - ���� ���� Ư���� ���� �̹��� ������ �̸��� ��������� �޾ƿ;��Ѵ�.
            @RequestParam("imageFileName") String imageFileName,
            HttpServletRequest request, HttpServletResponse response)  throws Exception;
	
	
	
	//���ο� ���� �̹����� �߰� ��� ����
	//��ȯ Ÿ���� void �� ���� ���� - ó�� �����ϴ� ���� �̹��� �߰� ��ɰ� ���
	//�ش� ���� ���ε�� ���õ� ������ ó���� ��, Ư���� ������ ó���� Ŭ���̾�Ʈ���� ���� �ʿ䰡 ����
	public void  addNewGoodsImage(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)  throws Exception;
	
	
	
	//���� �̹��� ������ �����ϴ� ��� ����
	//���ε� �� �̹��� ���ϰ� ���õ� ������ MultipartHttpServletRequest�� ���� �޾ƿ� ó���ϰ�
	//�ʿ信 ���� �����ͺ��̽��� ������ ������ �ݿ��Ѵ�.
	public void modifyGoodsImageInfo(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)  throws Exception;
}
