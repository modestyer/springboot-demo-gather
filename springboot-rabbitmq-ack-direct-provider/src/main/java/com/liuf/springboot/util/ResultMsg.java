package com.liuf.springboot.util;

public class ResultMsg implements java.io.Serializable {
	/**   
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)    
	*/
	private static final long serialVersionUID = 1L;

	private boolean result;
	private String errorMessage; //返回执行结果信息
	private Integer errorCode;//返回状态码：success二选一
	private Object data;//返回数据集:objData二选一

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * 提供静态工厂创建实例，获得一个返回结果集
	 * @param msg
	 * @param data
	 * @param code
	 * @return
	 */
	public static ResultMsg getResultMsg(boolean result, String msg, Object data, Integer code) {
		ResultMsg resultMsg = new ResultMsg();
		resultMsg.setErrorCode(code);
		resultMsg.setErrorMessage(msg);
		resultMsg.setData(data);
		resultMsg.setResult(result);
		return resultMsg;
	}

	/**
	 * 提供静态工厂创建实例，获得一个返回结果集
	 * @param msg
	 * @param data
	 * @param code
	 * @return
	 */
	public static ResultMsg getResultMsg(boolean result, String msg, Integer code) {
		ResultMsg resultMsg = new ResultMsg();
		resultMsg.setErrorCode(code);
		resultMsg.setErrorMessage(msg);
		resultMsg.setResult(result);
		return resultMsg;
	}
	/**
	 * 提供静态工厂创建实例，获得一个返回结果集
	 *
	 * @param <T>
	 * @param msg
	 * @param
	 * @returnd
	 */
//	public static ResultMsg getResultMsg(String msg,Integer code) {
//		ResultMsg resultMsg = new ResultMsg();
//		resultMsg.setCode(code);
//		resultMsg.setMsg(msg);
//		return resultMsg;
//	}


}
