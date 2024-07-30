package com.PRY.DIKmarket.Services;

import com.PRY.buldHOUSE.models.Query;
import com.PRY.buldHOUSE.repositoryes.QueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class QueryService {
    private final QueryRepository queryRepository;


    @Autowired
    public QueryService(QueryRepository queryRepository) {
        this.queryRepository = queryRepository;
    }
    @Transactional
    public List<Query> findAll() {
        return queryRepository.findAll();
    }
    @Transactional
    public Query findOne(Long id) {
        // Если она есть (optional), если нет - null
        Optional<Query> foundQuery = queryRepository.findById(id);
        return foundQuery.orElse(null);
    }
    @Transactional
    public void update(Query query,
                       Long id) {
        Query existingQuery = queryRepository.findById(id).orElse(null);
        if (existingQuery != null) {
            existingQuery.setQueryName(query.getQueryName());
            existingQuery.setQueryScript(query.getQueryScript());
            existingQuery.setQueryComment(query.getQueryComment());
            queryRepository.save(existingQuery);

        }
    }


    @Transactional
    public void delete(Long id) {
        queryRepository.deleteById(id);
    }
}
