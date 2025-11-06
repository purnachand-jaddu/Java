package com.test.kafka;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.TopicPartition;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.listener.BatchAcknowledgingConsumerAwareMessageListener;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer
    implements BatchAcknowledgingConsumerAwareMessageListener<String, String> {

  @Autowired private KafkaListenerEndpointRegistry registry;

  @KafkaListener(
      topics = {"pause.test.topic"},
      containerFactory = "containerFactory")
  @Override
  public void onMessage(
      List<ConsumerRecord<String, String>> records,
      Acknowledgment acknowledgment,
      @NotNull Consumer<?, ?> consumer) {
    System.out.println("On message invoked");
    List<ConsumerRecord<String, String>> consumerRecords = filterRecords(records);
    for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
      System.out.println(consumerRecord.value());
    }
    acknowledgment.acknowledge();
  }

  private List<ConsumerRecord<String, String>> filterRecords(
      List<ConsumerRecord<String, String>> records) {
    List<ConsumerRecord<String, String>> filteredRecords = new ArrayList<>();
    Collection<MessageListenerContainer> containers = registry.getAllListenerContainers();
    for (ConsumerRecord<String, String> record : records) {
      if (record.timestamp() > 1684054350000L) {
        pausePartition(containers, record);
      } else {
        filteredRecords.add(record);
      }
    }
    return filteredRecords;
  }

  private void pausePartition(
      Collection<MessageListenerContainer> containers, ConsumerRecord<String, String> record) {
    for (MessageListenerContainer container : containers) {
      container.pausePartition(new TopicPartition(record.topic(), record.partition()));
    }
  }
}
