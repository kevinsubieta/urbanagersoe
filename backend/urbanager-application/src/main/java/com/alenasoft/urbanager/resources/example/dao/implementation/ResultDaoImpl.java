package com.alenasoft.urbanager.resources.example.dao.implementation;

import com.alenasoft.urbanager.api.Result;
import com.alenasoft.urbanager.resources.example.dao.interfaces.ResultDao;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

public class ResultDaoImpl extends AbstractDAO<Result> implements ResultDao {

    public ResultDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public long create(Result result) {
        return this.persist(result).id;
    }

    @Override
    public Result getById(long id) {
        return this.get(id);
    }
}
