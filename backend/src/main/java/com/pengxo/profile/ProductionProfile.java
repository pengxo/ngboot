package com.pengxo.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class ProductionProfile implements ProfileInterface {

	@Override
	public String toString() {
		return "This is the production profile";
	}

}
