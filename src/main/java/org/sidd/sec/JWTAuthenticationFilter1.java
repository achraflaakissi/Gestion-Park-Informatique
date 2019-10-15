package org.sidd.sec;

import java.io.IOException;import java.util.Date;
import javax.servlet.FilterChain;
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sidd.dao.UserRepository;
import org.sidd.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.fasterxml.jackson.databind.ObjectMapper; 
import io.jsonwebtoken.Jwts; 
import io.jsonwebtoken.SignatureAlgorithm;


public class JWTAuthenticationFilter1 extends UsernamePasswordAuthenticationFilter {
	@Autowired
	private UserRepository userRepository;
	
	private AuthenticationManager authenticationManager;
	private String NomComplet ;
	
	public JWTAuthenticationFilter1(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
		HttpServletResponse response) throws AuthenticationException {
		org.sidd.entites.User user=null;
		try
		{
			user = new ObjectMapper().readValue(request.getInputStream(), org.sidd.entites.User.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		NomComplet=user.getFullname();
		System.out.println("**********");
		System.out.println("username : "+user.getUsername());
		System.out.println("Password : "+user.getPassword());
		return authenticationManager.authenticate(
		new UsernamePasswordAuthenticationToken(
			user.getUsername(),
			user.getPassword()
		));
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
		User springUser=(User)authResult.getPrincipal();
		String jwtToken= Jwts.builder().setSubject(springUser.getUsername())
				.setExpiration(new Date(System.currentTimeMillis()+SecurityConstants.EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET)
				.claim("roles", springUser.getAuthorities())
				.claim("fullname",springUser.getUsername())
				.compact();
		
		response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX+jwtToken);
	} 
}
