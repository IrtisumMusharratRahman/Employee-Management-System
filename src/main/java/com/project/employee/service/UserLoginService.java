package com.project.employee.service;

import com.project.employee.entity.UserLogin;
import com.project.employee.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserLoginService implements BaseService<UserLogin>{

    private final UserLoginRepository userLoginRepository;

    @Autowired
    public UserLoginService(UserLoginRepository userLoginRepository) {
        this.userLoginRepository = userLoginRepository;
    }

    @Override
    public UserLogin create(UserLogin entity) {
        return userLoginRepository.save(entity);
    }

    @Override
    public UserLogin update(UserLogin entity) {
        return userLoginRepository.save(entity);
    }

    @Override
    public void delete(UUID id) {
        userLoginRepository.deleteById(id);
    }

    @Override
    public List<UserLogin> getAll() {
        return userLoginRepository.findAll();
    }

    @Override
    public Optional<UserLogin> getById(UUID id) {
        return userLoginRepository.findById(id);
    }
}
