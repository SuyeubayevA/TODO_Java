package com.SanScrIT.TODO_list.dao;

import com.SanScrIT.TODO_list.entity.Task;
import com.SanScrIT.TODO_list.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class TaskDaoImpl implements TaskDao {
    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public TaskDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Task task) {
        String sql = "INSERT INTO task (name, description, duration) VALUES (?,?,?)";
        jdbcTemplate.update(sql, task.getName(),task.getDescription(), task.getDuration());
    }

    @Override
    public Task getById(int id) {
        String sql = "SELECT * FROM task WHERE id =?";
        return jdbcTemplate.queryForObject(sql, new TaskMapper(), id);
    }

    @Override
    public List<Task> findAll() {

        String sql = "SELECT * FROM task";
        return jdbcTemplate.query(sql, new TaskMapper());
    }

    @Override
    public void update(Task task) {
        String sql = "UPDATE task SET name=?, description=?, duration=? WHERE id=?";
        jdbcTemplate.update(sql, task.getName(),task.getDescription(), task.getDuration(), task.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM task WHERE id=?";
        jdbcTemplate.update(sql, id);
    }
}
