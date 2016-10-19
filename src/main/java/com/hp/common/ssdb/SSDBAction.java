package com.hp.common.ssdb;

public interface SSDBAction<T> {
	T go(SSDB ssdb) throws Exception;

}
