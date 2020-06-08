package com.soma.UserManagement.respository;

import com.soma.UserManagement.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
    Optional<User> findByUserId(Long userId);
}
