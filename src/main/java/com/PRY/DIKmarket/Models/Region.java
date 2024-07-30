package com.PRY.DIKmarket.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Data
@RequiredArgsConstructor
@Table(name = "regions", schema = "bh")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "region", cascade = CascadeType.ALL)
    private List<Form> form;

    @Column(name = "region_name")
    private String regionName;

    @Column(name = "create_dttm", updatable = false)
    private LocalDateTime createDttm;
    @PrePersist
    private void onCreate() {
        createDttm = LocalDateTime.now();
    }


}
