package com.bookshop01.order.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import com.bookshop01.order.dao.OrderDAO;
import com.bookshop01.order.vo.OrderVO;



//@Service : �ش� Ŭ������ ����Ͻ� ������ ����ϴ� ���� Ŭ���� ���� ��Ÿ����.
//Spring �� ������ ����ϰ� ���� ������ ����ü�� Ȱ���Ѵ�.

//"orderService" IoC �����̳ʿ��� �ش� ���� �ĺ��� �� �ִ�.
@Service("orderService")


//Ʈ����� ������ ���� ���ȴ�.
//propagation=Propagation.REQUIRED Ʈ������� �ʿ��� ��� ���ο� Ʈ������� �����ϰ�,
//�̹� ���� ���� Ʈ������� ������ �����ϵ��� �����Ѵ�.
// = �޼��� ������ Ʈ����� ������ ����Ǿ�� ���� �� �� �ִ�.
@Transactional(propagation=Propagation.REQUIRED)

//OrderService ����
public class OrderServiceImpl implements OrderService {
	
	// @Autowired spring ioc �����̳ʰ� �ڵ����� �� �����Ҷ� ���
	@Autowired
	//OrderDAO Ÿ�� ��ü ����
	private OrderDAO orderDAO;
	
	
	
	
	
	//OrderDAO �� ���� �ֹ� ��ǰ ��� ��ȸ
	public List<OrderVO> listMyOrderGoods(OrderVO orderVO) throws Exception{
		
		//OrderVo �ֹ��� ���õ� ������ ǥ���ϴ� �ڹ� ��ü
		//�ֹ� ��ǰ ����� OrderVO ��ü���� ����Ʈ�� ǥ���ȴ�. 
		// = ���� �ֹ� ��ǰ�� ���� �� �ִ� ����Ʈ�� ���� / ��Ƽ� ���� �� ����� ����
		List<OrderVO> orderGoodsList;
		
		

		//orderDAO.listMyOrderGoods(orderVO)
		//orderDAO �� listMyOrderGoods �޼ҵ� �ȿ� orderVO�� ������ ���� ��
		
		//orderGoodsList �� ������� �����Ѵ�. 
		orderGoodsList=orderDAO.listMyOrderGoods(orderVO);
		
		//��ȸ�� �ֹ� ��ǰ ��� ��ȯ
		return orderGoodsList;
	}
	
	
	
	
	
	
	//�߰� ��ǰ �ֹ� ��� �޼ҵ�
	//List<OrderVO> = ���� �߰��� �ֹ��� ���� ������ ���� OrderVO ��ü ����
	
	//�ֹ��� �߰��ϴ� ����̱� ������ �޼��� ���ο��� orderDAO�� ����� �����ͺ��̽���
	//�ֹ� ������ �����ϴ� �۾��� �̷������.
	public void addNewOrder(List<OrderVO> myOrderList) throws Exception{
		
		
		
		
		//orderDAO�� insertNewOrder�޼��带 �̿��Ѵ�.
		//insertNewOrder = ���� �ֹ� ������ �޾ƿ� �����ͺ��̽��� 
		//���ο� �ֹ��� �߰��ϴ� ����
		
		//insertNewOrder �޼��忡 myOrderList ����
		orderDAO.insertNewOrder(myOrderList);
		
		
		//īƮ���� �ֹ� ��ǰ �����Ѵ�.
		orderDAO.removeGoodsFromCart(myOrderList);
	}	
	
	
	
	
	//�ֹ� ID ������� �ֹ������� ��ȸ
	public OrderVO findMyOrder(String order_id) throws Exception{
		
		
		//orderDAO = �ֹ� ������ �׼��� ��ü
		//MyBatis ������ �׼��� �����ӿ�ũ�� �����
		//�ֹ� ������ �����ͺ��̽����� �������� ����
		return orderDAO.findMyOrder(order_id);
		
		//findMyOrder �ֹ� ������ ã�� ��� ����
		//order_id �Ű������� �ֹ� ID�� �޴´�.
		//OrderVO ��ȯ Ÿ�� �ֹ� ������ ��Ÿ���� Ŭ������ ��ü ��ȯ
		
		
	}

}
