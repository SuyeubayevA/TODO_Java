package com.SanScrIT.TODO_list.service;

import com.SanScrIT.TODO_list.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAll();

    void save(Task task);

    Task getById(int id);

    void update(Task task);

    void delete(int id);
}
