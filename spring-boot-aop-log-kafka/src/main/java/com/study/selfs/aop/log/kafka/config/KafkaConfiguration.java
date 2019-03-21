package com.study.selfs.aop.log.kafka.config;

import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class KafkaConfiguration {


    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Value("${spring.kafka.replication-factor}")
    private String factor;

    @Value("${spring.kafka.partitions}")
    private String partitions;

    @Bean
    public NewTopic topic() throws Exception{
        if(!StringUtils.isNumeric(factor)){
            throw new IllegalAccessException("factor 只能为整数！");
        }
        if(!StringUtils.isNumeric(partitions)){
            throw new IllegalAccessException("partitions 只能为整数！");
        }
        return new NewTopic(topicName,Integer.parseInt(factor.trim()),Short.parseShort(partitions.trim()));
    }


//    public ProducerFactory<String,String> producerFactory(){
//        return new DefaultKafkaProducerFactory<>(configMap);
//    }




}
