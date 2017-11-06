package cn.javass.dp.strategy.example5;

public class Client {
	public static void main(String[] args) {
		//������Ӧ��֧������
		PaymentStrategy strategyRMB = new RMBCash();
		PaymentStrategy strategyDollar = new DollarCash();


		//����ֻ�Ǵ�����ԣ����ǲ�û���ж�ʹ���ĸ����ԡ�


		//׼��С���֧������������
		PaymentContext ctx1 = new PaymentContext("С��",5000,strategyRMB);
		//��С��֧������
		ctx1.payNow();
		
		//�л�һ���ˣ���petter֧������
		PaymentContext ctx2 = new PaymentContext("Petter",8000,strategyDollar);
		ctx2.payNow();




		//���������ǲ�ͬ����չ��ʽ��һ������չ�����ģ���һ������չ���ԡ�




		//���������ӵ�֧����ʽ
		PaymentStrategy strategyCard = new Card();
		PaymentContext ctx3 = new PaymentContext2("С��",9000,"010998877656",strategyCard);   //�����������Ķ������һ��������
		ctx3.payNow();

		//���������ӵ�֧����ʽ
		PaymentStrategy strategyCard2 = new Card2("010998877656");    //��������Զ���һ��������   ������չ��ʽ��ʹ��һ���ֵ�������Դ�������ģ���һ����������Դ�ڲ����Լ�����չ��
		PaymentContext ctx4 = new PaymentContext("С��",9000,strategyCard2);
		ctx4.payNow();
	}
}