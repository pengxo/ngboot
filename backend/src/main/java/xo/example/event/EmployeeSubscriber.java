package xo.example.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EmployeeSubscriber implements ApplicationListener<EmployeeEvent> {

	@Override
	public void onApplicationEvent(final EmployeeEvent event) {
		System.out.println("Spring event with type " + event.getType());
	}

}
