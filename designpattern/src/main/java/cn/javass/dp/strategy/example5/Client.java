package cn.javass.dp.strategy.example5;

public class Client {
	public static void main(String[] args) {
		//创建相应的支付策略
		PaymentStrategy strategyRMB = new RMBCash();
		PaymentStrategy strategyDollar = new DollarCash();


		//下面只是传入策略，但是并没有判断使用哪个策略。


		//准备小李的支付工资上下文
		PaymentContext ctx1 = new PaymentContext("小李",5000,strategyRMB);
		//向小李支付工资
		ctx1.payNow();
		
		//切换一个人，给petter支付工资
		PaymentContext ctx2 = new PaymentContext("Petter",8000,strategyDollar);
		ctx2.payNow();




		//后面两种是不同的扩展形式，一种是扩展上下文，另一种是扩展策略。




		//测试新添加的支付方式
		PaymentStrategy strategyCard = new Card();
		PaymentContext ctx3 = new PaymentContext2("小王",9000,"010998877656",strategyCard);   //这里让上下文对象多了一个参数。
		ctx3.payNow();

		//测试新添加的支付方式
		PaymentStrategy strategyCard2 = new Card2("010998877656");    //在这里，策略多了一个参数。   这种扩展方式，使得一部分的数据来源于上下文，另一部分数据来源于策略自己的扩展。
		PaymentContext ctx4 = new PaymentContext("小张",9000,strategyCard2);
		ctx4.payNow();
	}
}
