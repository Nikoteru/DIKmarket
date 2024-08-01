package com.PRY.DIKmarket.Controllers;

import com.PRY.DIKmarket.Services.FormService;
import com.PRY.DIKmarket.Models.Form;
import com.PRY.DIKmarket.Repositoryes.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final FormService formService;
    private RegionRepository regionRepository;

    @Autowired
    public MainController(FormService formService,
                          RegionRepository regionRepository
    ) {
        this.formService = formService;
        this.regionRepository = regionRepository;
    }
    @GetMapping("/index.html")
    public String getMain(Model model) {
        model.addAttribute("form", new Form());
        model.addAttribute("region", regionRepository.findAll());
        return "main/index";
    }
}

