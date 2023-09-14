package com.example.myfirstwebapp.myfirstwebapp.login;

import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {
	
	public boolean authenticate(String username, String password) {
		
		return (("ashish").equalsIgnoreCase(username) && ("dummy").equalsIgnoreCase(password));
	}

}
