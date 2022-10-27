package com.vebinar.dao;

import com.vebinar.entity.User;
import com.vebinar.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO user_table (NAME, EMAIL, AGE) VALUES (?,?,?)";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getAge());
    }

    @Override
    public User getById(int id) {
        String sql = "select * from user_table where id = ?";
        return jdbcTemplate.queryForObject(sql, new UserMapper(), id);
    }

    public List<User> findAll() {

        String sql = "SELECT * FROM user_table";
        return jdbcTemplate.query(sql, new UserMapper());
    }

    @Override
    public void update(User user) {
        String sql = "update user_table set name = ?, email = ?, age = ? where id = ?";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getAge(), user.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "delete from user_table where id = ?";
        jdbcTemplate.update(sql, id);
    }
}
