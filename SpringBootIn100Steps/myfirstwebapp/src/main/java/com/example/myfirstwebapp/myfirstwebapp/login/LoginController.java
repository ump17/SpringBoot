package com.example.myfirstwebapp.myfirstwebapp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
	//now- welcome controller
	
	@Autowired
	private AuthenticationService authenticationService;
	
//	private Logger logger = LoggerFactory.getLogger(getClass());
//	@RequestMapping("/login")
//	public String goToLoginPage( @RequestParam String userName, ModelMap model) {
//		model.put("userName", userName);
//		logger.info("userName is {}",userName);
//		System.out.println("coming..............."+userName);
//		return "login";
//	}
	
//	@GetMapping("/login")
//	public String goToLoginPage() {
//		return "login";
//	}
//	
//	@PostMapping("/login")
//	public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
//		
//		if(authenticationService.authenticate(name,password)) {
//			model.put("name",name);
//			model.put("password",password);
//			return "homePage";
//		}
//		model.put("errorMsg", "Invalid credentials!! try again");
//		return "login";
//		
//	}
	
    @GetMapping("/")
	public String goToLoginPage(ModelMap model) {
    	model.put("name", getLoggedinUsername());
		return "homePage";
	}
    
    public String getLoggedinUsername() {
    	SecurityContext context = SecurityContextHolder.getContext();
    	org.springframework.security.core.Authentication authentication = context.getAuthentication();
    	String username = authentication.getName();
    	return username;
    }
}
