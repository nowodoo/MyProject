package cn.javass.dp.observer.example1;

/**
 * �۲��߽ӿڣ�����һ�����µĽӿڸ���Щ��Ŀ�귢���ı��ʱ��֪ͨ�Ķ���
 */
public interface Observer {
	/**
	 * ���µĽӿ�
	 * @param subject ����Ŀ����󣬺û�ȡ��Ӧ��Ŀ������״̬
	 */
	public void update(Subject subject);

}

