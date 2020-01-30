package xo.example.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsMessageReceiver {

	@JmsListener(destination = "jms.message.endpoint")
	public void receiveMessage(final JmsMessage msg) {
		System.out.println("The successful received jms message is: " + msg);
	}

}
