package com.PRY.DIKmarket.Controllers;

import com.PRY.DIKmarket.Services.QueryExecutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class QueryExecutionController {

    private final QueryExecutionService queryExecutionService;

    @Autowired
    public QueryExecutionController(QueryExecutionService queryExecutionService) {
        this.queryExecutionService = queryExecutionService;
    }

    @GetMapping("/execute/{id}")
    public String executeQueryById(@PathVariable Long id, Model model) {
        List<Map<String, Object>> queryResults = queryExecutionService.execute(id);
        model.addAttribute("queryResults", queryResults);
        return "main/execute"; // Имя вашего шаблона для результатов
    }

    @PostMapping("/execute")
    public String executeQuery(@RequestParam("queryId") Long queryId, Model model) {
        List<Map<String, Object>> queryResults = queryExecutionService.execute(queryId);
        model.addAttribute("queryResults", queryResults);
        return "/main/execute"; // Замените на имя вашего шаблона для результатов
    }
}

