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
@Table(name = "status", schema = "bh")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "status", cascade = CascadeType.ALL)
    private List<Form> form;

    @Column(name = "status_name")
    private String statusName;

    @Column(name = "create_dttm", updatable = false)
    private LocalDateTime createDttm;
    @PrePersist
    private void onCreate() {
        createDttm = LocalDateTime.now();
    }


}
