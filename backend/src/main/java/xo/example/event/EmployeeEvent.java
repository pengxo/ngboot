package xo.example.event;

import org.springframework.context.ApplicationEvent;

/**
 * Event class for dealing with events in Spring.
 * 
 * @author pengxing
 *
 */
public class EmployeeEvent extends ApplicationEvent {

	private static final long serialVersionUID = 7048135157255161744L;

	private final String type;

	public EmployeeEvent(final Object source, final String type) {
		super(source);
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
