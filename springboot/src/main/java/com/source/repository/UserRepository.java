package com.source.repository;

import com.source.entity.User;

import java.util.List;

public interface UserRepository {

    public List<User> findAll();
    public User findById(int id);
    public void save(User user);
    public void update(User user);
    public void deleteById(int id);
}
