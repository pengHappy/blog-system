package com.hp.common.event;

import java.util.concurrent.Executors;

import org.springframework.stereotype.Service;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

@Service
public class EBus {
	private EventBus asyncbus = new AsyncEventBus(
			Executors.newFixedThreadPool(8));
	private EventBus bus = new EventBus();
	public void registasync(Object object) {
		asyncbus.register(object);
	}

	public void sendasync(E e) {
		asyncbus.post(e);
	}

	public void regist(Object object) {
		bus.register(object);
	}

	public void send(E e) {
		bus.post(e);
	}
	public void sendAll(E e){
		send(e);
		sendasync(e);
	}
}
