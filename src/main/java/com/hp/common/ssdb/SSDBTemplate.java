package com.hp.common.ssdb;

public class SSDBTemplate {
	public void setSsdbPool(SSDBPool ssdbPool) {
		this.ssdbPool = ssdbPool;
	}

	private SSDBPool ssdbPool;

	public <T> T execute(SSDBAction<T> action) {
		SSDB ssdb = null;

		try {
			ssdb = ssdbPool.getResource();
			T result = action.go(ssdb);
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			throw new SSDBException(e.getMessage(), e);
		} finally {
			if (ssdb != null) {
				ssdbPool.returnResource(ssdb);
			}
		}
	}
}
