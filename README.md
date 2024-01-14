# kafka-producer-example

# documents

## Open Source Kafka Startup in local ##

1. Start Zookeeper Server

    ```sh bin/zookeeper-server-start.sh config/zookeeper.properties```

    ```bin\windows\zookeeper-server-start.bat config\zookeeper.properties```

2. Start Kafka Server / Broker

    ```sh bin/kafka-server-start.sh config/server.properties```

    ```bin\windows\kafka-server-start.bat config\server.properties```

3. Create topic

    ```sh bin/kafka-topics.sh --bootstrap-server localhost:9092 --create --topic NewTopic --partitions 3 --replication-factor 1```

    ```bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --create --topic NewTopic --partitions 3 --replication-factor 1```

4. list out all topic names

    ``` sh bin/kafka-topics.sh --bootstrap-server localhost:9092 --list ```

    ``` bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --list ```

5. Describe topics
  
    ``` sh bin/kafka-topics.sh --bootstrap-server localhost:9092 --describe --topic NewTopic ```

    ``` bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --describe --topic NewTopic ```



6. Produce message

    ```sh bin/kafka-console-producer.sh --broker-list localhost:9092 --topic NewTopic```

    ```bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic NewTopic```


7. consume message

    ``` sh bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic NewTopic --from-beginning ```

    ``` bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic NewTopic --from-beginning ```

## Postman ##

1. Send the message as pathvariable

    ```GetMapping : "/producer-app/publish/{message}"```
    ```GET: http://localhost:8181/producer-app/publish/user```

2. Send the customer as request body

    ```PostMapping : "/producer-app/publish"```
    ```POST: http://localhost:8181/producer-app/publish```
    Body:
    ```{
            "id":103,
            "name":"Ranga",
            "email": "ranga123@gmail.com",
            "phoneNum":"12365499877"
        }```


# kafka-installation using Docker Container

### Start docker desktop before executing any command

### Move to the kafka-installation folder then execute below command in CMD
```docker compose -f docker-compose.yml up -d```
```f -> file name```
```d -> Run in backgroud```

### Verify the zookeeper and kafka status
#### Check the docker images
```docker images```
#### Check the running containers
```docker ps```

# Command uses 

### Move into Kafka container
```docker exec -it <kafka_conatiner_id> /bin/sh```
### Go inside kafka installation folder
```cd /opt/kafka_<version>/bin```
### Create Kafka topic
```kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --topic quickstart```
### Start Producer app (CLI)
```kafka-console-producer.sh --topic quickstart --bootstrap-server localhost:9092```
### Start consumer app (CLI)
```kafka-console-consumer.sh --topic quickstart --from-beginning --bootstrap-server localhost:9092```
