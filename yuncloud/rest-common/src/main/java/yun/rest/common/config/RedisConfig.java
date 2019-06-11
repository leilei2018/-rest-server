package yun.rest.common.config;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate fastjsonRedisTemplate(){
        RedisTemplate fastjsonRedisTemplate = new RedisTemplate();
        StringRedisSerializer stringSerializer = new StringRedisSerializer();
        fastjsonRedisTemplate.setKeySerializer(stringSerializer);
        fastjsonRedisTemplate.setHashKeySerializer(stringSerializer);

        FastJsonRedisSerializer fjSerializer = new FastJsonRedisSerializer(Object.class);

        //注意：由fastjson反序列返回的对象是JSONObject对象，所以就必须强制转换具体的clazz
        fastjsonRedisTemplate.setValueSerializer(fjSerializer);
        fastjsonRedisTemplate.setHashValueSerializer(fjSerializer);
        return fastjsonRedisTemplate;
    }

}
