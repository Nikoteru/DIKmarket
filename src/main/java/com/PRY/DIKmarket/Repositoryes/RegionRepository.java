package com.PRY.DIKmarket.Repositoryes;

import com.PRY.DIKmarket.Models.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
    Region findByRegionName (String regionName);
}
