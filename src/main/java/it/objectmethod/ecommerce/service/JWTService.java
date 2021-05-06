package it.objectmethod.ecommerce.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import it.objectmethod.ecommerce.entity.User;
import it.objectmethod.ecommerce.service.dto.UserDTO;
import it.objectmethod.ecommerce.service.mapper.UserMapper;

@Component
public class JWTService {
	
	@Autowired 
	private UserMapper userMapper;

	private static final String MY_SECRET_JWT_KEY = "my-secret-jwt-key";

	public String createJWTToken(User user) {

		Calendar cal = Calendar.getInstance();

		int seconds = cal.get(Calendar.SECOND) + 30;
		if (seconds > 60) {
			seconds = seconds - 60;
			cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + 1);
		}
		cal.set(Calendar.SECOND, seconds);

		Algorithm alg = Algorithm.HMAC256(MY_SECRET_JWT_KEY);
		String token = JWT.create().withClaim("user_id", user.getUserId()).withClaim("user_name", user.getUserName())
				.withExpiresAt(cal.getTime()).sign(alg);

		return token;
	}

	public boolean checkJWTToken(String jwtToken) {
		boolean valid = false;
		Algorithm alg = Algorithm.HMAC256(MY_SECRET_JWT_KEY);
		try {
			JWTVerifier ver = JWT.require(alg).build();
			DecodedJWT decoded = ver.verify(jwtToken);

			Long userId = decoded.getClaim("user_id").asLong();
			String userName = decoded.getClaim("user_name").asString();

			System.out.println("Utente verificato! " + userId + " - " + userName);
			valid = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return valid;
	}
	
	public Long getUserIdFromToken(String token) {
		Algorithm alg = Algorithm.HMAC256(MY_SECRET_JWT_KEY);

		JWTVerifier ver = JWT.require(alg).build();
		DecodedJWT decoded = ver.verify(token);

		Long userId = decoded.getClaim("user_id").asLong();
		return userId;
	}
	
	public String getUserToken(UserDTO userDto) {
		User user = userMapper.toEntity(userDto);
		JWTService serv = new JWTService();
		String token = serv.createJWTToken(user);
		
		return token;
	}
}