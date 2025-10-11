package com.chris.cmarket_order_service.Auth.Model;

import com.chris.cmarket_order_service.Auth.Converter.JwtToUserConverter;
import com.chris.cmarket_order_service.User.Contracts.UserJWT;
import com.chris.cmarket_order_service.User.Dto.UserDTO;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.ArrayList;
import java.util.Collection;

@Getter
public class UserDetailsImpl implements UserDetails, UserJWT {

    @Serial
    private static final long serialVersionUID = 1L;

    @Setter(AccessLevel.NONE)
    private UserDTO userDto;

    /**
     * @param userDto User DTO mapped from claims from converter {@link JwtToUserConverter}
     */
    public UserDetailsImpl(UserDTO userDto) {
        this.userDto = userDto;
    }

    /**
     * @return user DTO name
     */
    public String getName() {
        return this.userDto.getName();
    }

    /**
     * @return user DTO id
     */
    public Long getId() {
        return this.userDto.getId();
    }

    @Override
    public String getUuid() {
        return this.getUsername();
    }

    @Override
    public String getUsername() {
        return this.userDto.getUuid();
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }
}
