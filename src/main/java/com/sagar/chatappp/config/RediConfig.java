package com.sagar.chatappp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.listener.PatternTopic;

import com.sagar.chatappp.dto.Receiver;

@Configuration
public class RediConfig {
	
	@Bean
	Receiver receiver()
	{
		return new Receiver();
	}
	
	@Bean
	MessageListenerAdapter listnerAdapter(Receiver receiver)
	{
		return new MessageListenerAdapter(receiver,"receiveMessage");
	}
	
	@Bean
	StringRedisTemplate redisTemplate(RedisConnectionFactory connectionFactory)
	{
		return new StringRedisTemplate(connectionFactory);
	}
	
	@Bean
	RedisMessageListenerContainer container (RedisConnectionFactory connectionFactory,
			MessageListenerAdapter listenerAdapter)
	{
		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.addMessageListener(listenerAdapter, new PatternTopic("chat"));

		return container;
	}

}
