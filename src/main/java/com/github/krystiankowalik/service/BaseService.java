package com.github.krystiankowalik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public class BaseService<T> implements IService<T> {

    private JpaRepository<T, Long> dao;

    @Autowired
    public BaseService(JpaRepository<T, Long> dao) {
        this.dao = dao;
    }


    @Override
    public T save(T object) {
        return dao.save(object);
    }

    @Override
    public List<T> save(Iterable<T> objects) {
        return dao.save(objects);
    }

    @Override
    public T get(long id) {
        return dao.findOne(id);
    }

    @Override
    public void delete(T object) {
        dao.delete(object);
    }

    @Override
    public void delete(Iterable<T> objects) {
        dao.delete(objects);
    }

    @Override
    public void delete(long id) {
        dao.delete(id);
    }
}
