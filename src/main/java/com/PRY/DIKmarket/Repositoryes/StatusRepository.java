package com.PRY.DIKmarket.Repositoryes;

import com.PRY.DIKmarket.Models.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    Status findByStatusName (String statusName);
}
