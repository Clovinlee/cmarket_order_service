package com.chris.cmarket_order_service.Auth.Converter;

import com.chris.cmarket_order_service.Auth.Model.UserDetailsImpl;
import com.chris.cmarket_order_service.User.Mapper.JwtClaimsToUserDtoMap;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

@Component
@AllArgsConstructor
public class JwtToUserConverter implements Converter<Jwt, UsernamePasswordAuthenticationToken> {
    @Override
    @NonNull
    public UsernamePasswordAuthenticationToken convert(Jwt source) {
        String subject = source.getSubject();
        Map<String, Object> sourceClaims = source.getClaims();

        UserDetails userPrincipal = new UserDetailsImpl(
                JwtClaimsToUserDtoMap.map(subject, sourceClaims)
        );

        return new UsernamePasswordAuthenticationToken(userPrincipal, source, Collections.emptyList());
    }
}
