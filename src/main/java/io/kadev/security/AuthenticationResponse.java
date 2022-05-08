package io.kadev.security;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class AuthenticationResponse {

	private final String jwt;
	
}
