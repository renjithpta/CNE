package com.ibs.techcoe.poc.consmer;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.ibs.techcoe.poc.consmer.domain.User;
@Component
public class ConsumerListener {
	@Autowired
	private Logger logger;

	@StreamListener(Sink.INPUT)
	public void loggerSink(Message<User> message) {
		logger.info("Message Received:  " + message.getPayload().getUsername());
	
	}
}
