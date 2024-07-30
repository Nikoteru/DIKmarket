package com.PRY.DIKmarket.Repositoryes;

import com.PRY.DIKmarket.Models.KEF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KEFRepository extends JpaRepository<KEF, Long> {
    KEF findByShareHolderAndSiteId(String shareHolder, Long siteId);
}
