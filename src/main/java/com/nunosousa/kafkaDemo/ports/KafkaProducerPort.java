package com.nunosousa.kafkaDemo.ports;

import com.nunosousa.kafkaDemo.enums.EventType;
import com.nunosousa.kafkaDemo.models.UserData;

public interface KafkaProducerPort {
  void produceUserMessage(EventType eventType, UserData userData);
}
