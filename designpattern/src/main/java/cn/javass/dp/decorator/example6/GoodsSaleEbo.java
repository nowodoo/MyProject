package cn.javass.dp.decorator.example6;

public class GoodsSaleEbo implements GoodsSaleEbi{
	
	public boolean sale(String user,String customer, SaleModel saleModel) {


		//这里原有的方法。   以后要是需要装饰这个方法的话，就直接将这个方法提炼到接口中去就好了。
		System.out.println(user+"保存了"+customer+"购买 "+saleModel+" 的销售数据");
		return true;
	}
}
