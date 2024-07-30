package com.PRY.DIKmarket.configs;

import com.PRY.DIKmarket.Models.KEF;
import com.PRY.DIKmarket.Repositoryes.KEFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class KEFInit implements CommandLineRunner {

    private final KEFRepository kefRepository;

    @Autowired
    public KEFInit(KEFRepository kefRepository) {
        this.kefRepository = kefRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        KEFInit();
    }

    private void KEFInit() {
        // Пары данных для добавления
        Object[][] kefToAdd = {
                {"Поляков Р.Ю.", 0.30, 2L},
                {"Родионов А.А.", 0.30, 2L},
                {"Вязовкин М.В.", 0.1, 2L},
                {"Демьяненко Ю.С.", 0.05, 2L},
                {"Проект", 0.25, 1L},
        };

        // Перебираем данные и добавляем их, если они еще не существуют
        for (Object[] data : kefToAdd) {
            String shareHolder = (String) data[0];
            Double percent = (Double) data[1];
            Long siteId = (Long) data[2];

            // Проверяем, существует ли уже запись с такой комбинацией shareHolder и siteId
            if (kefRepository.findByShareHolderAndSiteId(shareHolder, siteId) == null) {
                KEF kef = new KEF();
                kef.setShareHolder(shareHolder);
                kef.setPercent(percent);
                kef.setSiteId(siteId);
                kefRepository.save(kef);
            }
        }
    }
}
