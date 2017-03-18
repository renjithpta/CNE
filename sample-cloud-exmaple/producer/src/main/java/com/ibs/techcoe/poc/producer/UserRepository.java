package com.ibs.techcoe.poc.producer;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibs.techcoe.poc.producer.domain.User;

public interface UserRepository extends MongoRepository<User, Long> {
}
