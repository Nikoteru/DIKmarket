package com.PRY.DIKmarket.Services;

import com.PRY.DIKmarket.Models.*;
import com.PRY.DIKmarket.Repositoryes.FormRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FormService {

    private final FormRepository formRepository;

    private static final Logger logger = LoggerFactory.getLogger(FormService.class);

    @Autowired
    public FormService(FormRepository formRepository) {
        this.formRepository = formRepository;
    }

    public void saveForm(Form form) {



        formRepository.save(form);
        logger.info("Форма успешно сохранена: {}", form);
    }

    public List<Form> findAll() {
        List<Long> statusIds = Arrays.asList(1L, 2L, 3l);
        return formRepository.findAllByStatusIdInOrderByCreateDttmDesc(statusIds);
    }

    public Form findOne(Long id) {
        // Если она есть (optional), если нет - null
        Optional<Form> foundQuery = formRepository.findById(id);
        return foundQuery.orElse(null);
    }


    @Transactional
    public void update(Form form,
                       Long id) {
        Form existingForm = formRepository.findById(id).orElse(null);
        assert existingForm != null;
        if (existingForm != null) {
            Status status = form.getStatus();
            Region region = form.getRegion();
            if (status != null && status.getId()==null) {
                status = null;
            }
            if (region != null && region.getId()==null) {
                region = null;
            }
            existingForm.setStatus(status);
            existingForm.setRegion(region);
            existingForm.setUserFIO(form.getUserFIO());
            existingForm.setPhoneNumber(form.getPhoneNumber());
            existingForm.setEmail(form.getEmail());
            existingForm.setUserComment(form.getUserComment());
            existingForm.setWorkerComment(form.getWorkerComment());
            existingForm.setProjectIncome(form.getProjectIncome());
            existingForm.setProjectCost(form.getProjectCost());
            formRepository.save(existingForm);

        }
    }

    @Transactional
    public void delete(Long id) {
        formRepository.deleteById(id);
    }
}
