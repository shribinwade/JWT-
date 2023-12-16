package in.JWTexample.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.JWTexample.demo.Jwt.JwtUtils;
import io.jsonwebtoken.Claims;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		JwtUtils util = new JwtUtils();
		String Token = util.generateToken("AA885", "SHRIHARI", "WhySo$erious");
		//String Token="eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJBQTg4NSIsInN1YiI6IlNIUklIQVJJIiwiaXNzIjoiU2hyaWhhcmkiLCJpYXQiOjE3MDI3MDI4NTMsImV4cCI6MTcwMjcwMjkxM30.uP6N4MfiBV4NA2Pl1ej3xO-Lga2nyxs6BEYSoukBp4A";
		System.out.println(Token);
		
		Claims claims = util.getClaims("WhySo$erious", Token);
		System.out.println(claims.getId());
		System.out.println(claims.getSubject());
		System.out.println(claims.getExpiration());

		
	}

}
