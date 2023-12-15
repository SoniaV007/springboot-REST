package net.javaguides.springboot.service;

import net.javaguides.springboot.entity.user;

import java.util.List;

public interface userService {
    user createUser(user u);
    List<user> findAll();
    user updateUser(Long id, user user);
    void deleteUser(Long id);
    user findByID(Long id);
}
