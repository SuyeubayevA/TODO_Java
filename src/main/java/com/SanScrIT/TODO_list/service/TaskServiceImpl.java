package com.SanScrIT.TODO_list.service;

import com.SanScrIT.TODO_list.dao.TaskDao;
import com.SanScrIT.TODO_list.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    public TaskDao taskDao;

    @Override
    public List<Task> findAll() {
        return taskDao.findAll();
    }

    @Override
    public void save(Task task) {
        taskDao.save(task);
    }

    @Override
    public Task getById(int id) {
        return taskDao.getById(id);
    }

    @Override
    public void update(Task task) {
        taskDao.update(task);
    }

    @Override
    public void delete(int id) {
        taskDao.delete(id);
    }
}
