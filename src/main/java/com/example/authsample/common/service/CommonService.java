package com.example.authsample.common.service;

import com.example.authsample.common.exception.PendekarException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface CommonService<T, Z> {

    Long getNum();

    T save(T entity) throws PendekarException;

    T getById(Z pk) throws PendekarException;

    Boolean delete(Z pk) throws PendekarException;

    List<T> getAll() throws PendekarException;

    void deleteAll() throws PendekarException;

    //pageable
    Page<T> getPageableList(String sSearch, int startPage, int pageSize, Sort sort) throws PendekarException;
}
