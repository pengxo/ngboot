package com.pengxo.oauth2;

import java.util.Objects;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class Oauth2RestController {

	@GetMapping(path = "/api/employees/me")
	public ResponseEntity<UserProfile> profile() {

		// Build some dummy data to return for testing
		final User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		final String email = "xingbo.peng@pentasys.de";

		final UserProfile profile = new UserProfile();
		profile.setName(user.getUsername());
		profile.setEmail(email);

		return ResponseEntity.ok(profile);
	}

	public static class UserProfile {
		private String name;
		private String email;

		public String getName() {
			return name;
		}

		public void setName(final String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(final String email) {
			this.email = email;
		}

		@Override
		public int hashCode() {
			return Objects.hash(email, name);
		}

		@Override
		public boolean equals(final Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final UserProfile other = (UserProfile) obj;
			return Objects.equals(email, other.email) && Objects.equals(name, other.name);
		}

		@Override
		public String toString() {
			return "UserProfile [name=" + name + ", email=" + email + "]";
		}

	}

}
