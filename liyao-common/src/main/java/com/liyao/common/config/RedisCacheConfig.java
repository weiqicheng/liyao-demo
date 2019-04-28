package com.liyao.common.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.lang.reflect.Method;

/**
 * 以spring配置文件来管理的redis缓存配置类
 */
@Configuration
@EnableCaching//开启缓存
public class RedisCacheConfig extends CachingConfigurerSupport {

    /**
     * 连接池最大连接数（使用负值表示没有限制）
     */
    @Value("${spring.redis.pool.max-active}")
    private Integer maxActive;
    /**
     * 连接池最大阻塞等待时间（使用负值表示没有限制）
     */
    @Value("${spring.redis.pool.max-wait}")
    private Integer maxWait;
    /**
     * 连接池中的最大空闲连接
     */
    @Value("${spring.redis.pool.max-idle}")
    private Integer maxIdle;
    /**
     * 连接池中的最小空闲连接
     */
    @Value("${spring.redis.pool.min-idle}")
    private Integer minIdle;

    @Value("${spring.redis.sentinel.nodes}")
    private String redisNodes;

    @Value("${spring.redis.sentinel.master}")
    private String master;

    private static Logger logger = LoggerFactory.getLogger(RedisCacheConfig.class);

    public RedisCacheConfig() {
        super();
    }


    /**
     * redis哨兵配置
     */
    @Bean
    public RedisSentinelConfiguration redisSentinelConfiguration() {
        RedisSentinelConfiguration configuration = new RedisSentinelConfiguration();
        String[] host = redisNodes.split(",");
        for (String redisHost : host) {
            String[] item = redisHost.split(":");
            String ip = item[0];
            String port = item[1];
            configuration.addSentinel(new RedisNode(ip, Integer.parseInt(port)));
        }
        configuration.setMaster(master);
        return configuration;
    }

    @Bean
    public JedisConnectionFactory redisConnectionFactory(JedisPoolConfig jedisPoolConfig,RedisSentinelConfiguration redisSentinelConfiguration) {
        JedisConnectionFactory jedisConnectionFactory =
                new JedisConnectionFactory(redisSentinelConfiguration, jedisPoolConfig);
        return jedisConnectionFactory;
    }

    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 最大空闲数
        jedisPoolConfig.setMaxIdle(maxIdle);
        // 最大建立连接等待时间
        jedisPoolConfig.setMaxWaitMillis(maxWait);
        // 是否在从池中取出连接前进行检验,如果检验失败,则从池中去除连接并尝试取出另一个
        jedisPoolConfig.setTestOnBorrow(true);
        // 在空闲时检查有效性, 默认false
        jedisPoolConfig.setTestWhileIdle(true);
        return jedisPoolConfig;
    }


    /**
     * 实例化 RedisTemplate 对象
     *
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        // 创建一个模板类
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        // 将刚才的redis连接工厂设置到模板类中
        template.setConnectionFactory(redisConnectionFactory);
        // 设置key的序列化器
        template.setKeySerializer(new StringRedisSerializer());

        // 设置value的序列化器
        //使用Jackson 2，将对象序列化为JSON
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        //json转对象类，不设置默认的会将json转成hashmap
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        return template;
    }

    /**
     * 申明缓存管理器，会创建一个切面（aspect）并触发Spring缓存注解的切点（pointcut）
     * 根据类或者方法所使用的注解以及缓存的状态，这个切面会从缓存中获取数据，将数据添加到缓存之中或者从缓存中移除某个值
     *
     * @return
     */
    @Bean
    public CacheManager cacheManager(RedisTemplate<?, ?> redisTemplate) {
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate);
        redisCacheManager.setDefaultExpiration(60 * 60);//设置key-value超时时间
        return redisCacheManager;
    }

    /**
     * keyGenerator方法帮我们注册了一个key的生成规则，就不用我们写spel表达式了，根据反射的原理读取类名+方法名+参数。但是我们有时候还是需要结合spel的。
     *
     * @return
     */
    @Bean
    public KeyGenerator customKeyGenerator() {
        return new KeyGenerator() {
            public Object generate(Object o, Method method, Object... objects) {
                StringBuilder sb = new StringBuilder();
                sb.append(o.getClass().getName());
                sb.append(method.getName());
                for (Object obj : objects) {
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };
    }
}
