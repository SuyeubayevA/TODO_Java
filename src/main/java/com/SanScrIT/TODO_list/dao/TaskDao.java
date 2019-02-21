package com.SanScrIT.TODO_list.dao;

import com.SanScrIT.TODO_list.entity.Task;

import java.util.List;

public interface TaskDao {
    void save(Task task);

    Task getById(int id);

    List<Task> findAll();

    void update(Task task);

    void delete(int id);
}
