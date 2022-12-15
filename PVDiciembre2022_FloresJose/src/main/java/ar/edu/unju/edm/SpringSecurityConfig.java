package ar.edu.unju.edm;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;

@Configuration
public class SpringSecurityConfig {
		
	
	@Bean
	SecurityFilterChain web(HttpSecurity http) throws Exception {
		http
			// ...
			.authorizeHttpRequests(authorize -> authorize                                  
				.requestMatchers("/").permitAll()
				.requestMatchers("/listar", "/logout/**").permitAll()
				.requestMatchers("/form/**", "/eliminar/**").hasRole("Docente")
//				.requestMatchers("/eliminar").hasRole("Docente")
//				.requestMatchers("/listar").access(new WebExpressionAuthorizationManager("hasRole('Docente') and hasRole('Estudiante')"))   
				.anyRequest().denyAll() 
			)
			.formLogin(form -> form
					.loginPage("/login")
					.permitAll()
			)
	        .logout(logout -> logout                                                
		            .logoutUrl("/logout")                                            
		            .logoutSuccessUrl("/my/index")
		            .permitAll()
//		            .logoutSuccessHandler(logoutSuccessHandler)                         
		            .invalidateHttpSession(true)                                        
//		            .addLogoutHandler(logoutHandler)                                    
//		            .deleteCookies(cookieNamesToClear)
		            );
//
//		.formLogin(form -> form
//			.loginPage("/login")
//			.permitAll()
//		);
//		 http
//	        .logout(logout -> logout                                                
//	            .logoutUrl("/logout")                                            
//	            .logoutSuccessUrl("/my/index")
//	            .permitAll()
////	            .logoutSuccessHandler(logoutSuccessHandler)                         
//	            .invalidateHttpSession(true)                                        
////	            .addLogoutHandler(logoutHandler)                                    
////	            .deleteCookies(cookieNamesToClear)                                  
//	        );

		return http.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService()throws Exception{
				
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User
	            .withUsername("Estudiante")
	            .password(passwordEncoder().encode("Estudiante"))
	            .roles("Estudiante")
	            .build());
		 manager.createUser(User
		            .withUsername("Docente")
		            .password(passwordEncoder().encode("Docente"))
//		            .roles("Docente","Estudiante")
		            .roles("Docente")
		            .build());
		
		return manager;
	}
	
	@Bean 
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}
