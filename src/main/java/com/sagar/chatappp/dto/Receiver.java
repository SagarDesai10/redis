package com.sagar.chatappp.dto;

import java.util.concurrent.atomic.AtomicInteger;

public class Receiver {
	
	private AtomicInteger counter =new AtomicInteger();
	
	public void receiveMessage(String message) {
        counter.incrementAndGet();
    }

    public int getCount() {
        return counter.get();
    }

}
