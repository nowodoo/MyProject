package cn.javass.dp.state.example8;
/**
 * ����״̬�ӿ�
 */
public interface State {
	/**
	 * ִ��״̬��Ӧ�Ĺ��ܴ���
	 * @param ctx �����ĵ�ʵ������
	 */
	public void doWork(StateMachine ctx);
}
