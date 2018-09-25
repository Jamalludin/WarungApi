package com.warung.makmi.warungapi.service;

import java.util.List;

public interface BaseService<T> {

    List<T> findPerPage(String search, Integer limit, Integer offset);

    List<T> find();

    T findById(Object paramter);

    void save(T t);

    void update(T t);

    void delete(Object paramter);

}
