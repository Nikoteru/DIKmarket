package com.PRY.DIKmarket.Repositoryes;

import com.PRY.DIKmarket.Models.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryRepository extends JpaRepository<Query, Long> {

}
