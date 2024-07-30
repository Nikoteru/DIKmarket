package com.PRY.DIKmarket.Models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Data
@RequiredArgsConstructor
@ToString(exclude = {"project", "status"})
@Table(name = "form", schema = "bh")
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


//    @NotEmpty(message = "Имя должно быть заполнено")
    @Size(min = 5, max = 100, message = "Введите имя")
    @Column(name = "user_fio")
    private String userFIO;

//    @NotEmpty(message = "Введите почту для обратной связи")
    @Email(message = "Введите email")
    @Column(name="email")
    private String email;

//    @NotEmpty(message = "Введите номер телефона для обратного звонка")
    @Column(name="phone_number")
    @Size(min = 11, max = 18, message = "Введите номер телефона")
    private String phoneNumber;

    @Column(name="user_comment")
    private String userComment;

    @Column(name="site_id")
    private Long siteCode = 1l;

    @Column(name="project_cost")
    private Integer projectCost;

    @Column(name="project_income")
    private Integer projectIncome;

    @Column(name="worker_comment")
    private String workerComment;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "region_id")
    private Region region;

    @Column(name = "create_dttm", updatable = false)
    private LocalDateTime createDttm;
    @PrePersist
    private void onCreate() {
        createDttm = LocalDateTime.now();
        if (status == null) {
            // Устанавливаем значение по умолчанию, если оно не установлено
            status = new Status();  // Предполагается, что у Status есть конструктор без параметров
            status.setId(1L);  // Установите значение по умолчанию
        }
    }

}
