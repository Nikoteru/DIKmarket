package com.PRY.DIKmarket.Repositoryes;

import com.PRY.DIKmarket.Models.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormRepository extends JpaRepository<Form, Long> {
    List<Form> findAllByStatusIdInOrderByCreateDttmDesc(List<Long> statusIds);

}
