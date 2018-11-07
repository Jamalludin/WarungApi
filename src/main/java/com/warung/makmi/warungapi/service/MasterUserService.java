package com.warung.makmi.warungapi.service;

import com.warung.makmi.warungapi.dto.User;
import com.warung.makmi.warungapi.repository.MasterUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasterUserService implements BaseService<User>{

    @Autowired
    private MasterUserRepository repository;

    @Override
    public List<User> findPerPage(String search, Integer limit, Integer offset) {
        return null;
    }

    @Override
    public List<User> find() {
        return repository.find();
    }

    @Override
    public User findById(Object paramter) {
        return null;
    }

    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(Object paramter) {

    }
}
