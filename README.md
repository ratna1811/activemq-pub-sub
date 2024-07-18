# activemq-pub-sub
Code-Flow
--------------
1. In postman hit the below url which is configured in controller - MessageController.java
	http://localhost:8089/topic/publishMessage
2. From MessageController we call the publishMessage of MessagePublisher.java using the messagePublisher object.
3. From MessagePublisher, jmsTemplate.convertAndSend message is called with destination queue name(Topic.Learning) and Message entity object.
4. MessageSubscriber listens to this queue and receives the message.
5. Configuration related to listener container and jmsTemplate are configured in config file with @Configuration and @EnableJms annotations. jmsTemplate internally takes care of setting up connections with the queue and creating sessions.
6. In the application.properties file we will set the ActiveMQ broker url, username, password and packages trusted as all.
	spring.application.name=activemq-pub-sub
	server.port=8089
	spring.activemq.broker-url=tcp://localhost:61616
	spring.activemq.user=admin
	spring.activemq.password=admin
	spring.activemq.packages.trust-all=true