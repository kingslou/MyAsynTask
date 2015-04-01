package com.example.myasyntask;
import java.util.HashMap;
import java.util.Map;

import android.os.AsyncTask;

/**
 * 定义一个抽象类，便于实现不同业务逻辑的task,如加载图片，检查网络连接等不同的业务逻辑
 * @author jin
 *
 */
public abstract class MyAsynTask extends AsyncTask<Object,Integer,Object> implements ITask {

	protected TaskMode exexuteMode = TaskMode.masync;
	protected Map<String, Object> dataHolder = new HashMap<String, Object>();
	protected TaskCallback callback;
	protected IProcessing processing;
	
	@Override
	public TaskMode getExecuteMode() {
		// TODO Auto-generated method stub
		return exexuteMode;
	}

	@Override
	public ITask setCallBack(TaskCallback callback) {
		// TODO Auto-generated method stub
		this.callback = callback;
		return this;
	}

	@Override
	public void doProcessing(Object result) {
		// TODO Auto-generated method stub
		if(null!=processing){
			processing.processing(result);
		}
	}

	@Override
	public ITask setProcessing(IProcessing processing) {
		// TODO Auto-generated method stub
		this.processing = processing;
		return this;
	}

	@Override
	public void addParams(String name, Object value) {
		// TODO Auto-generated method stub
		dataHolder.put(name, value);
	}

	@Override
	public Object getParams(String name) {
		// TODO Auto-generated method stub
		return dataHolder.get(name);
	}

	@Override
	protected Object doInBackground(Object... params) {
		// TODO Auto-generated method stub
		return doTask();
	}
	 @Override
    protected void onPostExecute(Object result) {
        doCallback(result);
    }

}
