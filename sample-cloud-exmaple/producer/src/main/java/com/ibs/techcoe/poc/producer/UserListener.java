package com.ibs.techcoe.poc.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterDeleteEvent;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;
import com.ibs.techcoe.poc.producer.domain.User;

 @Component
public class UserListener extends AbstractMongoEventListener<User> {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserListener.class);

	private MessageChannel output;

	public UserListener(MessageChannel output) {
		this.output = output;
	}

	@Override
	public void onAfterSave(AfterSaveEvent<User> event) {
		LOGGER.info("onAfterSave {}", event);
		output.send(
				MessageBuilder.withPayload(event.getSource())
						.build());
	}

	@Override
	public void onAfterDelete(AfterDeleteEvent<User> event) {
		LOGGER.info("onAfterDelete {}", event);
	}
	
 }