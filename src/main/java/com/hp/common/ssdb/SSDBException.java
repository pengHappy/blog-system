package com.hp.common.ssdb;

public class SSDBException extends RuntimeException{
	private static final long serialVersionUID = 849276316160517039L;

	public SSDBException(String msg,Throwable e){
		super(msg,e);
	}
	public SSDBException(String msg){
		super(msg);
	}
	public SSDBException(){}
}
