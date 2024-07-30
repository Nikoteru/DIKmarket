package com.PRY.DIKmarket.Security;

import com.PRY.DIKmarket.Models.AdminPassword;
import com.PRY.DIKmarket.Repositoryes.AdminPasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
@Component
public class UserServiceSecurity implements UserDetailsService {
    @Autowired
    private AdminPasswordRepository adminPasswordRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminPassword adminPassword = adminPasswordRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("Пользователь '%s' не найден", username)
                ));

//        System.out.println("User found: " + username + ", password: " + adminPassword.getPassword());

        // Создаем авторитет с ролью "ROLE_ADMIN"
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");
        List<GrantedAuthority> authorities = Collections.singletonList(authority);

        // Возвращаем объект UserDetails
        return new org.springframework.security.core.userdetails.User(
                adminPassword.getLogin(),
                adminPassword.getPassword(),
                authorities
        );
    }
}

