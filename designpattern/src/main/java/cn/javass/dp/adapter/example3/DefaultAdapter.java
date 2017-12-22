package cn.javass.dp.adapter.example3;

import java.util.List;

public class DefaultAdapter implements LogDbOperateApi{

	public void createLog(LogModel lm) {
		System.out.println("DB createLog===========");
	}

	public void updateLog(LogModel lm) {
		System.out.println("DB updateLog===========");
	}

	public void removeLog(LogModel lm) {
		
	}

	public List<LogModel> getAllLog() {
		return null;
	}

}
