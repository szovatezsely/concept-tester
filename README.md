# concept-tester
A test project where future concepts can be tested.

## Kafka producer/consumer
The goal is to test Apache Kafka functionality on high level.
To use all the implemented methodologies, 
we need to set-up the project with the following commands:

1. docker-compose up -d
2. docker exec -it kafka kafka-topics --create --topic demo-topic --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1
3. Start ConceptTesterApplication.

Once the containers and the related application has been started, we can send
messages to the created demo-topic using RequestParam named message. 
- curl -X POST "http://localhost:8080/api/messages?message=HelloKafka"

Once the application was stopped, we can destroy the related containers as well:
- docker-compose down