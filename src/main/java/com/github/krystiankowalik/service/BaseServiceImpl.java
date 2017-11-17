package com.github.krystiankowalik.service;

import com.github.krystiankowalik.model.item.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public class BaseServiceImpl<T> implements BaseService<T> {

    private JpaRepository<T, Long> dao;

    public BaseServiceImpl(JpaRepository<T, Long> dao) {
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
    public List<T> getAll() {
        return dao.findAll();
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

    @Override
    public boolean exists(long id) {
        return dao.exists(id);
    }
}
