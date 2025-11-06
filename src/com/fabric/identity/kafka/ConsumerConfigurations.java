package com.test.kafka;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;

@EnableKafka
@Configuration
public class ConsumerConfigurations {

  @Bean
  public ConsumerFactory<String, String> consumerFactory() {
    Map<String, Object> properties = new HashMap<>();
    properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    properties.put(ConsumerConfig.GROUP_ID_CONFIG, "default");
    return new DefaultKafkaConsumerFactory<>(
        properties, StringDeserializer::new, StringDeserializer::new);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, String> containerFactory() {
    ConcurrentKafkaListenerContainerFactory factory =
        new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConcurrency(1);
    factory.setConsumerFactory(consumerFactory());
    factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL);
    factory.setBatchListener(true);
    return factory;
  }
}
