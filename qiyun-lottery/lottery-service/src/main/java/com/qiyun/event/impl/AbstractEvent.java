package com.qiyun.event.impl;

import com.qiyun.event.Event;

import java.util.Map;

/**
 * 事件抽象实现类
 * @author ysh
 *
 */
public abstract class AbstractEvent implements Event {

	private Event nextEvent;

	@SuppressWarnings("unchecked")
	abstract public Map execute(Map request);

	public Event getNextEvent() {
		return nextEvent;
	}

	public void setNextEvent(Event nextEvent) {
		this.nextEvent = nextEvent;
	}

}
