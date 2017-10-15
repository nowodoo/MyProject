package cn.javass.dp.strategy.example4;

public class Client2 {
	public static void main(String[] args) {

		//在这里可以进行判断。

		//1：选择并创建需要使用的策略对象
		Strategy strategy = new CooperateCustomerStrategy();    //替换算法的时候，只需要改这里就好了。
		//2：创建上下文
		Price ctx = new Price(strategy);
		
		//3：计算报价
		double quote = ctx.quote(1000);
		System.out.println("向客户报价："+quote);
	}
}
