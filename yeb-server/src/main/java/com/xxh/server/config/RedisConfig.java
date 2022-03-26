package com.xxh.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author xxh
 * @since 2022/3/26 11:43
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String,Object> redisTemplate(LettuceConnectionFactory connectionFactory){
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        //String类型 key序列器
        template.setKeySerializer(new StringRedisSerializer());
        //String类型 value序列器
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        //Hash类型 key序列器
        template.setHashKeySerializer(new StringRedisSerializer());
        //Hash类型 value序列器
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setConnectionFactory(connectionFactory);
        return template;
    }
}
