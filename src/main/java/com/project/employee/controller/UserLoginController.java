package com.project.employee.controller;

import com.project.employee.entity.UserLogin;
import com.project.employee.service.DailyAttendanceService;
import com.project.employee.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/user_login")
public class UserLoginController {

    private final UserLoginService userLoginService;

    @Autowired
    public UserLoginController(UserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }

    @PostMapping
    public UserLogin create(@RequestBody UserLogin entity) {
        return userLoginService.create(entity);
    }

    @PutMapping
    public UserLogin update(@RequestBody UserLogin entity) {
        return userLoginService.update(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) {
        userLoginService.delete(id);
    }

    @GetMapping
    public List<UserLogin> getAll() {
        return userLoginService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<UserLogin> getById(@PathVariable("id") UUID id) {
        return userLoginService.getById(id);
    }
}
