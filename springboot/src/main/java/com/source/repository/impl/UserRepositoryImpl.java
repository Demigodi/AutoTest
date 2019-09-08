package com.source.repository.impl;

import com.source.entity.User;
import com.source.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    //springboot会通过配置文件自动配置JdbcTemplate对象
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("select * from user",new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User findById(int id) {
        return jdbcTemplate.queryForObject("select * from user where id =?",new Object[]{id},new BeanPropertyRowMapper<>(User.class));

    }

    @Override
    public void save(User user) {
        jdbcTemplate.update("insert into user(id,name,score) values (?,?,?)",user.getId(),user.getName(),user.getScore());
    }

    @Override
    public void update(User user) {
        jdbcTemplate.update("update user set name=?,score=? where id=?",user.getName(),user.getScore(),user.getId());
    }

    @Override
    public void deleteById(int id) {
        jdbcTemplate.update("delete from user where id = ?",id);
    }
}
