package com.PRY.DIKmarket.configs;

import com.PRY.DIKmarket.Models.Site;
import com.PRY.DIKmarket.Repositoryes.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SiteInit implements CommandLineRunner {

    private final SiteRepository siteRepository;

    @Autowired
    public SiteInit(SiteRepository siteRepository) {
        this.siteRepository = siteRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        SiteInit();
    }

    private void SiteInit() {
        // Пары данных для добавления
        Object[][] siteToAdd = {
                {"DIKmarket", "Доставка из Китая"},
        };

        // Перебираем данные и добавляем их, если они еще не существуют
        for (Object[] data : siteToAdd) {
            String siteName = (String) data[0];
            String siteType = (String) data[1];

            // Проверяем, существует ли уже запись с такой комбинацией shareHolder и siteId
            if (siteRepository.findBySiteName(siteName) == null) {
                Site site = new Site();
                site.setSiteName(siteName);
                site.setSiteType(siteType);
                siteRepository.save(site);
            }
        }
    }
}
