package com.pengxo.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DevelopmentProfile implements ProfileInterface {

	@Override
	public String toString() {
		return "This is the development profile.";
	}
}
