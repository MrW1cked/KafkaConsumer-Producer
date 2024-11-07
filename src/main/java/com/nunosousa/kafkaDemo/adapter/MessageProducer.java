package com.nunosousa.kafkaDemo.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nunosousa.kafkaDemo.enums.EventType;
import com.nunosousa.kafkaDemo.event.UserEvent;
import com.nunosousa.kafkaDemo.models.UserData;
import com.nunosousa.kafkaDemo.ports.KafkaProducerPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageProducer implements KafkaProducerPort {

  private final KafkaTemplate<String, Object> kafkaTemplate;

  @Value("${spring.kafka.topic}")
  private String topic;

  @Override
  public void produceUserMessage(EventType eventType, UserData userData) {
    UserEvent userEvent = UserEvent.builder()
        .eventType(eventType)
        .timestamp(System.currentTimeMillis())
        .id(userData.getId())
        .name(userData.getName())
        .description(userData.getEmail())
        .source(userData.getSource())
        .build();
      log.info("Sending message to Kafka: {}", userEvent);
    kafkaTemplate.send(topic, userData.getId(), userEvent);
      log.info("Message sent to Kafka: {}", userEvent);
  }

  // Consumer to listen to messages from Kafka
  @KafkaListener(topics = "${spring.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
  public void consumeUserMessage(@Payload UserEvent userEvent) {
      log.info("Received message from Kafka: {}", userEvent);
  }

}
