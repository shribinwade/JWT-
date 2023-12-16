package in.JWTexample.demo.Jwt;

import java.util.Base64;
import java.util.Date;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtils {

	//generate token
	public String generateToken(String id,String subject,String key) {
		
		return Jwts.builder()
				   .setId(id)
				   .setSubject(subject)
				   .setIssuer("Shrihari")
				   .setIssuedAt(new Date(System.currentTimeMillis()))
				   .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60))
				   .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encode(key.getBytes()))
				   .compact();
	}
	
	//get claims
	public Claims getClaims(String key,String token) {
		
		return Jwts.parser()
				   .setSigningKey(Base64.getEncoder().encode(key.getBytes()))
				   .parseClaimsJws(token)
				   .getBody();
	}
}
