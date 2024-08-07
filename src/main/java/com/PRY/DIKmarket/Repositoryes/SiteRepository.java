package com.PRY.DIKmarket.Repositoryes;

import com.PRY.DIKmarket.Models.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteRepository extends JpaRepository<Site, Long> {
    Site findBySiteName (String siteName);
}
