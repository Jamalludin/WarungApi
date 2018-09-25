package com.warung.makmi.warungapi.repository;

import java.util.List;

public interface BaseRepository<T> {

    List<T> findPerPage(String search, Integer limit, Integer offset);

    List<T> find();

    T findById(Object parameter);

    void save(T t);

    void update(T t);

    void delete(Object parameter);
}
