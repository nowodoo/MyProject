package cn.javass.dp.visitor.example3;
/**
 * �����ʵ�Ԫ�صĽӿ�
 */
public abstract class Element {
	/**
	 * ���ܷ����ߵķ���
	 * @param visitor �����߶���
	 */
	public abstract void accept(Visitor visitor);
}

