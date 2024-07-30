package com.PRY.DIKmarket.Repositoryes;

import com.PRY.DIKmarket.Models.AdminPassword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminPasswordRepository extends JpaRepository<AdminPassword, Long> {
    Optional<AdminPassword> findByLogin (String login);

}
