package com.github.krystiankowalik.service;

import java.util.List;

public interface BaseService<T> {

    T save(T object);

    List<T> save(Iterable<T> objects);

    T get(long id);

    List<T> getAll();

    void delete(T object);

    void delete(Iterable<T> objects);

    void delete(long id);

    boolean exists(long id);




}
