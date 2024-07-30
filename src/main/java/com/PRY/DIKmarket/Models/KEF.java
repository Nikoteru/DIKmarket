package com.PRY.DIKmarket.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="kef_info", schema = "bh")
public class KEF {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "shareholder")
    private String shareHolder;

    @Column(name = "percent")
    private Double percent;

    @Column(name = "site_id")
    private Long siteId;
}
