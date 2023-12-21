package com.bookshop01.order.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.bookshop01.order.vo.OrderVO;



//Spring���� ������ �׼��� ����(DAO)�� ����ü
//�ش� Ŭ������ �����ͺ��̽����� ��ȣ�ۿ��� ����ϴ� DAO Ŭ�������� ��Ÿ����,
//������ ��ϵ� ������ �ǹ��Ѵ�.

//"orderDAO"�� ���� �̸����� ��� / Spring �����̳ʿ��� �ش� �� ���� ����

//������ ���̽����� ��� ���!!!!!
//SQL ���� �����ϰ� ��� ��ȯ�ϴ� ����!!!!!!!!!!!!
@Repository("orderDAO")
public class OrderDAOImpl implements OrderDAO {
	
	
	//Spring �����ӿ�ũ���� �ش� �ʵ带 �ڵ����� �����ϵ��� �����ϴ� ����
	@Autowired
	
	//SqlSession = MyBatis�� ���� / �����ͺ��̽����� ��ȣ�ۿ��� ����ȭ�ϱ� ���� �ڹ� ORM
	//SqlSession Mybatis���� SQL�� �����ϱ� ���� �ֿ��� �������̽�
	private SqlSession sqlSession;
	
	
	
	public List<OrderVO> listMyOrderGoods(OrderVO orderVO) throws DataAccessException{
		List<OrderVO> orderGoodsList=new ArrayList<OrderVO>();
		orderGoodsList=(ArrayList)sqlSession.selectList("mapper.order.selectMyOrderList",orderVO);
		return orderGoodsList;
	}
	
	
	
	
	
	
	
	//���� �ֹ� ������ �޾ƿ� �����ͺ��̽��� ���ο� �ֹ����� �߰��ϴ� ����
	public void insertNewOrder(List<OrderVO> myOrderList) throws DataAccessException{
		
		
		//���ο� �ֹ� ID�� �����ϱ�
		//selectOrderID �޼���� ���ο� �ֹ� ID�� �����ϴ� ����
		int order_id=selectOrderID();
		
		
		//�ֹ� ����Ʈ�� ��ȸ�ϸ� �� �ֹ� ������ ���ο� �ֹ� ID�� �����ϰ� �����ͺ��̽��� �߰�
		for(int i=0; i<myOrderList.size();i++){
			
			//.get (�÷���)
			OrderVO orderVO =(OrderVO)myOrderList.get(i);
			orderVO.setOrder_id(order_id);
			
			
			//MyBatis ��� - �����ͺ��̽��� ���ο� �ֹ� ������ �߰��ϴ� �κ�
			
			//mapper.order.insertNewOrder �� MyBatis SQL���� ���Ͽ���
			//�ش� SQL������ ã�� �����ϴµ� ���Ǵ� �ĺ���
			sqlSession.insert("mapper.order.insertNewOrder",orderVO);
		}
		
	}	
	
	
	
	
	
	
	public OrderVO findMyOrder(String order_id) throws DataAccessException{
		OrderVO orderVO=(OrderVO)sqlSession.selectOne("mapper.order.selectMyOrder",order_id);		
		return orderVO;
	}
	
	public void removeGoodsFromCart(OrderVO orderVO)throws DataAccessException{
		sqlSession.delete("mapper.order.deleteGoodsFromCart",orderVO);
	}
	
	public void removeGoodsFromCart(List<OrderVO> myOrderList)throws DataAccessException{
		for(int i=0; i<myOrderList.size();i++){
			OrderVO orderVO =(OrderVO)myOrderList.get(i);
			sqlSession.delete("mapper.order.deleteGoodsFromCart",orderVO);		
		}
	}	
	private int selectOrderID() throws DataAccessException{
		return sqlSession.selectOne("mapper.order.selectOrderID");
		
	}
}

