package com.PRY.DIKmarket.Services;

import com.PRY.buldHOUSE.models.Query;
import com.PRY.buldHOUSE.repositoryes.QueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class QueryExecutionService {

    private final JdbcTemplate jdbcTemplate;
    private final QueryRepository queryRepository;

    @Autowired
    public QueryExecutionService(JdbcTemplate jdbcTemplate, QueryRepository queryRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.queryRepository = queryRepository;
    }
    public Query getQueryById(Long queryId) {
        // Используем репозиторий для получения запроса по его идентификатору
        Optional<Query> optionalQuery = queryRepository.findById(queryId);

        // Если запрос найден, возвращаем его, иначе бросаем исключение или возвращаем null (в зависимости от вашей логики)
        return optionalQuery.orElse(null);
    }
    public List<Map<String, Object>> execute(Long queryId) {
        // Получаем SQL-запрос из базы данных по queryId
        String sqlQuery = "SELECT query_script FROM bh_query WHERE id = ?";
        String queryScript = jdbcTemplate.queryForObject(sqlQuery, String.class, queryId);

        // Выполняем SQL-запрос
        return jdbcTemplate.queryForList(queryScript);
    }
}