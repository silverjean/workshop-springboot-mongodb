package com.jeansilveira.workshopmongo.services;

import com.jeansilveira.workshopmongo.domain.User;
import com.jeansilveira.workshopmongo.repository.UserRepository;
import com.jeansilveira.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public Optional<User> findById(String id) {
        return repo.findById(id);
    }
}
