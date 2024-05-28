package com.CN.FitFusion.jwt;
import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.*;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.*;
import org.springframework.security.core.userdetails.*;
import java.util.*;
import javax.crypto.spec.*;
@Component
public class JwtAuthenticationHelper{

	String secret="fgljdydkjkjdlkdadjctyuiroejvcfhsdjpoenfrdaiuoieritjnfadhjeuoiturt";
	private static final long JWT_TOKEN_VALIDITY = 60*60;
	public String getUsernameFromToken(String token) {
		Claims claims = getClaimsFromToken(token);
		return claims.getSubject();
	}
	public Claims getClaimsFromToken(String token) {
		Claims claims = Jwts.parserBuilder().setSigningKey(secret.getBytes())
				.build().parseClaimsJws(token).getBody();
		return claims;
	}
	public boolean isTokenExpired(String token) {
		Claims claims = getClaimsFromToken(token);
		Date expDate = claims.getExpiration();
		return expDate.before(new Date());
	}

	public String generateToken(UserDetails userDetails) {
		Map<String,Object> claims = new HashMap<>();
		return Jwts.builder()
			.setClaims(claims)
			.setSubject(userDetails.getUsername())
			.setIssuedAt(new Date(System.currentTimeMillis()))
			.setExpiration(new Date(System.currentTimeMillis()+JWT_TOKEN_VALIDITY*1000))
			.signWith(new SecretKeySpec(secret.getBytes(),SignatureAlgorithm.HS512.getJcaName()),SignatureAlgorithm.HS512 )
			.compact();
	}
}
