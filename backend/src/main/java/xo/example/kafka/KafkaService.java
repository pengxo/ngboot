package xo.example.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(final String msg) {
		kafkaTemplate.send("springboot2", msg);
	}

	@KafkaListener(topics = "springboot2", groupId = "group-id")
	public void listen(final String message) {
		System.out.println("Received Messasge in group - group-id: " + message);
	}

}
