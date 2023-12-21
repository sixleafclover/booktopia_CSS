package com.bookshop01.order.service;

import java.util.List;
import java.util.Map;

import com.bookshop01.order.vo.OrderVO;

public interface OrderService {
	
	
	//����ڰ� �ֹ��� ��ǰ ��� ��ȸ
	//List<OrderVO> ��ȯ Ÿ�� / �ֹ��� ��ǰ ����� ���� OrderVO ��ü�� ����Ʈ ��ȯ
	public List<OrderVO> listMyOrderGoods(OrderVO orderVO) throws Exception;

	
	
	//���ο� �ֹ� �߰�
	//���ο� �ֹ� ������ ���� OrderVO ��ü�� ����Ʈ(List<OrderVO>)�� �Ű������� �޴´�.
	public void addNewOrder(List<OrderVO> myOrderList) throws Exception;

	
	
	//�ֹ� ID�� ������� Ư�� �ֹ��� ã�´�.
	//Ư�� �ֹ� ������ ���� OrderVO ��ü ��ȯ 
	//String order_id ã�����ϴ� �ֹ��� ID�� �Ű������� �޴´�.
	public OrderVO findMyOrder(String order_id) throws Exception;
	
	
}
