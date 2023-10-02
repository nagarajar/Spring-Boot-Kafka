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

3. Send the customer as request body

    ```PostMapping : "/producer-app/publish"```
   
    ```POST: http://localhost:8181/producer-app/publish```
   
    Body:
   
    ```{
            "id":103,
            "name":"Ranga",
            "email": "ranga123@gmail.com",
            "phoneNum":"12365499877"
        }```
