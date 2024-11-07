package com.nunosousa.kafkaDemo.adapter;

import com.nunosousa.kafkaDemo.enums.EventType;
import com.nunosousa.kafkaDemo.models.UserData;
import com.nunosousa.kafkaDemo.ports.KafkaProducerPort;
import com.nunosousa.kafkaDemo.ports.MainMenuPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainMenu implements MainMenuPort {

  private final KafkaProducerPort kafkaProducerPort;
  private final MessageProducer messageProducer; // Presume-se que o consumidor está na classe MessageProducer

  @Override
  public void start() {
    java.util.Scanner scanner = new java.util.Scanner(System.in);
    while (true) {
      System.out.println("\n===============================");
      System.out.println("       Kafka Message Menu       ");
      System.out.println("===============================");
      System.out.println(" 1 - 📤 Produce a message");
      System.out.println(" 2 - 📥 Consume a message");
      System.out.println(" 0 - 🚪 Exit");
      System.out.println("===============================");
      System.out.print("➡️  Enter your choice: ");

      int choice = scanner.nextInt();
      scanner.nextLine(); // Limpar o buffer

      System.out.println("\n-------------------------------");
      switch (choice) {
        case 1:
          System.out.println("📝 Preparing to produce a message...");
          produceMessage(scanner);
          break;
        case 2:
          System.out.println("👀 Waiting to consume a message...");
          consumeMessage();
          break;
        case 0:
          System.out.println("👋 Exiting the menu... Goodbye!");
          System.out.println("-------------------------------\n");
          return;
        default:
          System.out.println("❌ Invalid choice. Please try again.");
      }
      System.out.println("-------------------------------\n");
    }
  }

  private void produceMessage(java.util.Scanner scanner) {
    System.out.println("Enter the user name:");
    String userName = scanner.nextLine();
    System.out.println("Enter the user email:");
    String userEmail = scanner.nextLine();
    System.out.println("Enter the information source:");
    String source = scanner.nextLine();

    EventType eventType = null;
    while (eventType == null) {
      System.out.println("Enter the event type (CREATE, UPDATE, DELETE):");
      String eventTypeString = scanner.nextLine();
      try {
        eventType = EventType.valueOf(eventTypeString);
      } catch (IllegalArgumentException e) {
        System.out.println("Invalid event type.");
      }
    }

    UserData userData = UserData.builder()
            .id(java.util.UUID.randomUUID().toString())
            .name(userName)
            .email(userEmail)
            .source(source)
            .build();
    kafkaProducerPort.produceUserMessage(eventType, userData);
  }

  private void consumeMessage() {
    System.out.println("Waiting to consume a message from Kafka...");
    // Simulação de consumo - na prática, o KafkaListener em MessageProducer vai processar automaticamente
    // Podes adicionar uma lógica adicional aqui se for necessário para teste ou debug
  }
}