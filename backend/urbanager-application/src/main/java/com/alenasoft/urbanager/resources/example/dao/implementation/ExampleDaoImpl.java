package com.alenasoft.urbanager.resources.example.dao.implementation;

import com.alenasoft.urbanager.api.Example;
import com.alenasoft.urbanager.resources.example.dao.interfaces.ExampleDao;
import io.dropwizard.hibernate.AbstractDAO;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 * Implementation for ExampleDao.
 *
 * @author Luis Roberto Perez
 * @since 20-05-17
 */
public class ExampleDaoImpl extends AbstractDAO<Example> implements ExampleDao {

  public ExampleDaoImpl(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  @Override
  public Example findById(long id) {
    return get(id);
  }

  @Override
  public long create(Example example) {
    return persist(example).id;
  }

  @Override
  public List<Example> findAll() {
    return list(namedQuery("com.alenasoft.urbanager.api.Example.findAll"));
  }
}
