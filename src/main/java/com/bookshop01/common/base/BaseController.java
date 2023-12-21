package com.bookshop01.common.base;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.bookshop01.goods.vo.ImageFileVO;

//�߻� Ŭ����
public abstract class BaseController  {
	
	
	//�̹��� ���� ��� ��� �ʵ�
	//������ ��� ���!!!!!!!!!!!!
	//CURR_IMAGE_REPO_PATH ���� �̹��� ������� ��θ� ǥ���� ����� �̸�
	//"C:\\shopping\\file_repo" ���� ���� ������� ���
	private static final String CURR_IMAGE_REPO_PATH = "/shopping/file_repo";
	
	
	
	
	//MultipartHttpServletRequest�� ����Ͽ� ���� ���ε带 ó���ϴ� �޼���
	protected List<ImageFileVO> upload(MultipartHttpServletRequest multipartRequest) throws Exception{
		
		
//		ImageFileVO ��ü�� �����ϴ� ArrayList ����
//		�� ����Ʈ�� ���� ���ε� �������� �� ���Ͽ� ���� ������ ���� �������� ���ȴ�.
		List<ImageFileVO> fileList= new ArrayList<ImageFileVO>();
		
		
//		multipartRequest.getFileNames�� MultipartHttpServletRequest ��ü���� 	
//		��� ������ �̸��� �������� �޼���
//		Iterator<String>�� ��ȯ�ϸ� �� String�� ���ε�� ������ �̸� / Iterator�� ����
//		�� ������ �̸��� ������ �� ������ �ϳ��� ó���Ѵ�.
//		fileNames ������ ���� �̸����� ��� �ִ� Iterator<String> ��ü  
		Iterator<String> fileNames = multipartRequest.getFileNames();
		
		
//		������ ������ ������ �ִ��� Ȯ���Ѵ�.
		while(fileNames.hasNext()){
			
			//���� ó������ ���Ͽ� ���� ������ ���� ImageFileVO ��ü�� �����Ѵ�. 
			ImageFileVO imageFileVO =new ImageFileVO();
			
			//���� ������ �̸��� �����´�.
			String fileName = fileNames.next();
			
			//imageFileVO ��ü�� ���� Ÿ�� ����
			imageFileVO.setFileType(fileName);
			
			//���� ���Ͽ� ���� MultipartFile ��ü ���
			MultipartFile mFile = multipartRequest.getFile(fileName);
			
			//OriginalFilename ������ ���� �̸� ��������
			String originalFileName=mFile.getOriginalFilename();
			
			//imageFileVO ��ü�� ������ ���� �̸��� ����
			imageFileVO.setFileName(originalFileName);
			
			//imageFileVO ��ü�� ����Ʈ�� �߰��Ѵ�.
			fileList.add(imageFileVO);
			
			//����� ���� ������ ��Ÿ���� File ��ü�� �����Ѵ�.
			File file = new File(CURR_IMAGE_REPO_PATH +"/"+ fileName);
			
			//������ ���ε� �Ǿ����� Ȯ���Ѵ�.
			if(mFile.getSize()!=0){ //File Null Check
				
				//���� ������ �������� ������
				if(! file.exists()){ //��λ� ������ �������� ���� ���
					
					//������ �θ� ���丮�� �����ϰ�
					if(file.getParentFile().mkdirs()){ //��ο� �ش��ϴ� ���丮���� ����
						
							//�� ���� �����ϱ�
							file.createNewFile(); //���� ���� ����
					}
				}
				
				//���� ������ �����ϰų� ������ �����Ǿ����� ���ε� �� ������ ���� ���Ϸ� �����Ѵ�.
				mFile.transferTo(new File(CURR_IMAGE_REPO_PATH +"/"+"temp"+ "/"+originalFileName)); //�ӽ÷� ����� multipartFile�� ���� ���Ϸ� ����
			}
			
			// = ���ε� �� �� ���Ͽ� ���� ������ ImageFileVO�� ��ü�� �����
			// ���� ���Ϸ� �����ϴ� �۾�
			
		}
		
		//���ε� �� ���ϵ鿡 ���� ������ ����(add ��) ImageFileVO ��ü���� ����Ʈ�� ��ȯ�Ѵ�.
		return fileList;
		
	}
	
	
	
	
	//���� ���� ���� ��� (fileName �ʿ�)
	//�־��� ���� �̸��� �ش��ϴ� ������ �����Ѵ�.
	private void deleteFile(String fileName) {
		
		//������ ������ ��Ÿ���� File ��ü�� �����Ѵ�.
		//��δ� CURR_IMAGE_REPO_PATH �� ���� �̸��� fileName �� ������ �����.
		File file =new File(CURR_IMAGE_REPO_PATH+"/"+fileName);
		
		try{
			
			//���࿡ ������ ���ٸ� File ��ü�� ��Ÿ���� ������ �����Ѵ�.
			file.delete();
			
		}catch(Exception e){
			
			//���࿡ ���ܰ� �߻��Ѵٸ� ���� �ڵ带 ����Ѵ�.
			e.printStackTrace();
		}
	}
	
	
	
	//Ȯ���ڰ� .do�� ������ ��� ��û�� ���� ó���ϵ��� ������ ����
	//�޼��尡 GET, POST ��û ��θ� ó���� �� �ֵ��� �����Ǿ� �ִ�.
	@RequestMapping(value="/*.do" ,method={RequestMethod.POST,RequestMethod.GET})
	
	//ModelAndView �𵨰� ���� ������ �Բ� ������ �ִ� SpringMVC ���� ���Ǵ� Ŭ����
	//���� Ÿ���� ModelAndView �� viewForm
	protected  ModelAndView viewForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//��û ��ü���� viewName �̶�� �Ӽ��� ������ viewName ������ �����Ѵ�.
		//��Ʈ�ѷ����� ��ȯ�� ���� �̸� 
		String viewName=(String)request.getAttribute("viewName");
		
		//������ viewName�� ����� ModelAndView ��ü�� �����Ѵ�.
		//ModelAndView �� �𵨰� ���� ������ �Բ� �����Ҷ� ���
		ModelAndView mav = new ModelAndView(viewName);
		
		//������ ModelAndView ��ü�� ��ȯ�Ѵ�.
		//���� �並 �������ϰ� Ŭ���̾�Ʈ�� ������ ������.
		return mav;
	}
	
	
	
	
	//fixedSearchPeriod �� ���� �˻� �Ⱓ�� ����ϴ� �޼���
	protected String calcSearchPeriod(String fixedSearchPeriod){
		
		//�˻� �Ⱓ�� �����ϰ� ������, ������ ��, ��, ���� �����ϱ� ���� ���ڿ� ����
		String beginDate=null;
		String endDate=null;
		String endYear=null;
		String endMonth=null;
		String endDay=null;
		String beginYear=null;
		String beginMonth=null;
		String beginDay=null;
		
		
		//��¥�� �� �ڸ� ���ڸ� ���ڸ��� �����ϱ� ���� DecimalFormat��ü�� ����
		//1���̸� 01�� ����
		DecimalFormat df = new DecimalFormat("00");
		
		
		//Calendar �⺻ �ڹ� ����
		//������ ��¥�� �ð� ������ ������ �ִ� Calendar ��ü ���� 
		Calendar cal=Calendar.getInstance();
		
		
		//���� ��¥�� �������� ���� cal ��ü���� ������ ������ ��
		//�ش� ������ ���ڿ��� ��ȯ�Ͽ� �����ϴ� �κ�
		//(cal.get(Calendar.YEAR) �� cal ��ü���� ���� ������ �������� �޼���
		//Integer.toString�� ������ ���ڿ��� ��ȯ�ϴ� �޼���
		
		// = ����ð� ��Ÿ���� cal���� ���� ������ endYear�� ���ڿ��� ����
		endYear   = Integer.toString(cal.get(Calendar.YEAR));
		
		
		//����� 0���� ������ 11������ ���� ������ ������ 0�� 1���� ��Ÿ����.
		// 1�� ���� ���� ���� ���� ��´�.
		endMonth  = df.format(cal.get(Calendar.MONTH) + 1);
		
		endDay   = df.format(cal.get(Calendar.DATE));
		endDate = endYear +"-"+ endMonth +"-"+endDay;
		
		
		
		//fixedSearchPeriod �˻� �Ⱓ
		
		//fixedSearchPeriod�� null �̸� �˻� �Ⱓ�� 4���� ������ �����Ѵ�.
		if(fixedSearchPeriod == null) {
			//���� ������ 4 ���̳ʽ�
			cal.add(cal.MONTH,-4);
			
			
			
		//�˻��Ⱓ�� one_week�� �˻��Ⱓ�� ������ ������ �����Ѵ�.
		}else if(fixedSearchPeriod.equals("one_week")) {
			//���� �ð����� 7�� ���̳ʽ�
			cal.add(Calendar.DAY_OF_YEAR, -7);
			
		
			
		//�˻��Ⱓ�� one_week�� �˻��Ⱓ�� ������ ������ �����Ѵ�.
		}else if(fixedSearchPeriod.equals("two_week")) {
			//���� �ð����� 7�� ���̳ʽ�
			cal.add(Calendar.DAY_OF_YEAR, -14);
			
			

		//�˻� �Ⱓ�� one_month�� �˻��Ⱓ�� 1�������� �����Ѵ�.
		}else if(fixedSearchPeriod.equals("one_month")) {
			//���� �ð����� 1���� ���̳ʽ�
			cal.add(cal.MONTH,-1);
			
			
			
		//�˻� �Ⱓ�� two_month�� �˻��Ⱓ�� 2�������� �����Ѵ�.
		}else if(fixedSearchPeriod.equals("two_month")) {
			//���� �ð����� 2���� ���̳ʽ�
			cal.add(cal.MONTH,-2);
			
			
			
		//�˻� �Ⱓ�� three_month�� �˻��Ⱓ�� 3�������� �����Ѵ�.
		}else if(fixedSearchPeriod.equals("three_month")) {
			//���� �ð����� 3���� ���̳ʽ�
			cal.add(cal.MONTH,-3);
			
			
			
			//�˻� �Ⱓ�� four_month�� �˻��Ⱓ�� 4�������� �����Ѵ�.
		}else if(fixedSearchPeriod.equals("four_month")) {
			//���� �ð����� 4���� ���̳ʽ�
			cal.add(cal.MONTH,-4);
		}
		
//		= fixedSearchPeriod�� ���� �˻� �Ⱓ ����
		
		
		
		
		
		//�˻� �Ⱓ�� ���� ���� ���ϴ� �ڵ�
		
		//cal ��ü���� ���� ������ ������ ���ڿ��� ��ȯ�ѵ� beginYear �� ���� 
		beginYear   = Integer.toString(cal.get(Calendar.YEAR));
		
		//cal ���� ���� �� ���ϰ� beginMonth �� ���� 
		beginMonth  = df.format(cal.get(Calendar.MONTH) + 1);
		
		//cal ���� ���� �� ���ϰ� beginDay �� ����
		beginDay   = df.format(cal.get(Calendar.DATE));
		
		//������ ���� ������ ���� ��Ƽ� ��¥ ���
		beginDate = beginYear +"-"+ beginMonth +"-"+beginDay;
		
		
		//�˻� �����ϴ� ��¥ �˻� ������ ��¥
		return beginDate+","+endDate;
	}
	
}
