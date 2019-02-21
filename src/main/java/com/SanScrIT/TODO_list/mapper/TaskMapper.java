package com.SanScrIT.TODO_list.mapper;

import com.SanScrIT.TODO_list.entity.Task;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskMapper implements RowMapper<Task> {
    public Task mapRow(ResultSet resultSet, int i) throws SQLException{
        Task task = new Task();
        task.setId(resultSet.getInt("id"));
        task.setName(resultSet.getString("name"));
        task.setDescription(resultSet.getString("description"));
        task.setDuration(resultSet.getInt("duration"));
        return task;
    }
}
