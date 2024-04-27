package com.jeansilveira.workshopmongo.repository;

import com.jeansilveira.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UseRepository extends MongoRepository<User, String> {

}
