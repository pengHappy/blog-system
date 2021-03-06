package com.hp.common.ssdb;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class SSDBPoolConfig extends GenericObjectPoolConfig{
public SSDBPoolConfig(){
	 // defaults to make your life with connection pool easier :)
    setTestWhileIdle(true);
    setMinEvictableIdleTimeMillis(60000);
    setTimeBetweenEvictionRunsMillis(30000);
    setNumTestsPerEvictionRun(-1);
}
}
