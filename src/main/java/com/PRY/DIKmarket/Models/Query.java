package com.PRY.DIKmarket.Models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@Data
@Table(name = "query", schema = "bh")
@Entity
@RequiredArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Query {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "query_name")
    private String queryName;

    @Column(length = 4000, name = "query_script")
    private String queryScript;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "query_comment")
    private String queryComment;

    @Column(name = "create_dttm", updatable = false)
    private LocalDateTime createDttm;

    @PrePersist
    private void onCreate() {
        createDttm = LocalDateTime.now();
    }

}
