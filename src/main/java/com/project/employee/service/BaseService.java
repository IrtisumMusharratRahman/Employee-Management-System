package com.project.employee.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BaseService<T> {
    T create(T entity);
    T update(T entity);
    void delete(UUID id);
    List<T> getAll();
    Optional<T> getById(UUID id);
}
