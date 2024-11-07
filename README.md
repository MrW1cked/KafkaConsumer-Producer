
# Kafka Demo Project

Welcome to the Kafka Demo Project! This guide walks you through the project setup and usage.

---

## Project Overview

This project demonstrates:
- **Kafka Producer**: Publishes messages to a Kafka topic.
- **Kafka Consumer**: Listens for messages on a Kafka topic.
- **CLI Menu**: Command-line interface for selecting produce or consume options.

The setup uses Docker containers for easy Kafka and Zookeeper deployment.

---

## Prerequisites

- Docker
- Docker Compose

---

## Setup and Run with Docker

1. **Clone the Repository**
   ```
   git clone https://github.com/yourusername/kafka-demo-project.git
   cd kafka-demo-project
   ```

2. **Start Services**
   ```
   docker-compose up -d
   ```

3. **Verify Services**
   ```
   docker-compose ps
   ```

4. **Check Topic Initialization**
   ```
   docker-compose logs init-kafka
   ```

---

## Project Structure

- `MessageProducer` (KafkaProducerPort): Produces messages.
- `MainMenu` (MainMenuPort): CLI menu for producer and consumer.
- `docker-compose.yml`: Docker services for Kafka, Zookeeper, and topic init.

---

## Usage

1. **Run CLI**: Start the Java application

2. **Menu Options**:
   - **1 - Produce a message**: Enter message details for Kafka.
   - **2 - Consume a message**: Display incoming messages.
   - **0 - Exit**: Quit the application.

---

## Important Kafka Topics

- `user-events`: Stores user-related events with single partition and replication.

---

## Environment Configuration

- **Zookeeper**: Manages Kafka brokers on port 2181.
- **Kafka Broker**: Port 9092 for localhost, 29092 for inter-container communication.
- **Topic Initializer**: Creates `user-events` topic on startup.

---

## License

This project is open source and licensed under the MIT License.
