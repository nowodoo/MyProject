package cn.javass.dp.decorator.example6;

public class GoodsSaleEbo implements GoodsSaleEbi{
	
	public boolean sale(String user,String customer, SaleModel saleModel) {


		//����ԭ�еķ�����   �Ժ�Ҫ����Ҫװ����������Ļ�����ֱ�ӽ���������������ӿ���ȥ�ͺ��ˡ�
		System.out.println(user+"������"+customer+"���� "+saleModel+" ����������");
		return true;
	}
}
