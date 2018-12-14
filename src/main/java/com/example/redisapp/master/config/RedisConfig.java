package com.example.redisapp.master.config;

import io.lettuce.core.RedisURI;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

//@Configuration
//@EnableTransactionManagement
//public class RedisConfig implements TransactionManagementConfigurer {
@Configuration
@EnableTransactionManagement
public class RedisConfig  {


    @Bean
    public StringRedisTemplate redisTemplate() {
        StringRedisTemplate template = new StringRedisTemplate(redisConnectionFactory());
        // explicitly enable transaction support
        template.setEnableTransactionSupport(true);
        return template;
    }

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {

        URI redisURI = null;
        String urlLocal = "redis://sts:YkFVCTbvBTXknNwJwTFcyIECGQ2QXNxE@redis-18198.c12.us-east-1-4.ec2.cloud.redislabs.com:18198";
        String urlServer = System.getenv("REDIS_URL");
//        String urlServer = "redis://h:pb9a1233fb0dfd994001f7d3370a0efde3661de0557c1af7ec67722109fe6f259@ec2-54-209-190-123.compute-1.amazonaws.com:60039";

        try {

            if(urlServer != null && !urlServer.isEmpty()) {
                redisURI = new URI(urlServer);
            }else{
                redisURI = new URI(urlLocal);
            }

        } catch (URISyntaxException e) {
            e.printStackTrace();
            System.out.println("erro ao criar URI");
        }

        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(redisURI.getHost(), redisURI.getPort());
        config.setPassword(RedisPassword.of(redisURI.getUserInfo().split(":",2)[1]));

        return new LettuceConnectionFactory(config);
    }

//    @Override
//    public PlatformTransactionManager annotationDrivenTransactionManager() {
//        return new DataSourceTransactionManager(dataSource());;
//    }

//    @Bean
//    public DataSource dataSource() throws SQLException {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager() throws SQLException {
//        return new DataSourceTransactionManager(dataSource());
//    }



}
