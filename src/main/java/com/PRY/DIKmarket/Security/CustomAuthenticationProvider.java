package com.PRY.DIKmarket.Security;

import com.PRY.DIKmarket.Models.AdminPassword;
import com.PRY.DIKmarket.Repositoryes.AdminPasswordRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final AdminPasswordRepository adminPasswordRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomAuthenticationProvider(AdminPasswordRepository adminPasswordRepository, PasswordEncoder passwordEncoder) {
        this.adminPasswordRepository = adminPasswordRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();

        Optional<AdminPassword> adminPasswordOptional = adminPasswordRepository.findByLogin(userName);
        if (adminPasswordOptional.isEmpty()) {
            throw new BadCredentialsException("Unknown user " + userName);
        }

        AdminPassword adminPassword = adminPasswordOptional.get();
        String storedPassword = adminPassword.getPassword();

        if (!passwordEncoder.matches(password, storedPassword)) {
            throw new BadCredentialsException("Bad password");
        }

        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");
        List<GrantedAuthority> authorities = Collections.singletonList(authority);

        UserDetails principal = org.springframework.security.core.userdetails.User.builder()
                .username(adminPassword.getLogin())
                .password(storedPassword)
                .authorities(authorities)
                .build();

        return new UsernamePasswordAuthenticationToken(
                principal, password, principal.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}

