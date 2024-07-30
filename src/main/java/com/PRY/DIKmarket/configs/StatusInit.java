package com.PRY.DIKmarket.configs;

import com.PRY.DIKmarket.Models.Status;
import com.PRY.DIKmarket.Repositoryes.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StatusInit implements CommandLineRunner {

    private final StatusRepository statusRepository;

    @Autowired
    public StatusInit(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        StatusInit();
    }

    private void StatusInit() {
        // Пары данных для добавления
        String[][] statusToAdd = {
                {"Новый"},
                {"В обработке"},
                {"В работе"},
                {"Отмена"},
                {"Выполнен"},
                // Добавьте другие данные по аналогии
        };

        // Перебираем данные и добавляем их, если они еще не существуют
        for (String[] data : statusToAdd) {
            String statusName = data[0];

            // Проверяем, существует ли уже запись с таким кодом
            if (statusRepository.findByStatusName(statusName) == null) {
                Status status = new Status();
                status.setStatusName(data[0]);
                statusRepository.save(status);
            }
        }
    }
}
