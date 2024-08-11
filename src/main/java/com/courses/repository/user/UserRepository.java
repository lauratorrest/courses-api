package com.courses.repository.user;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserDto, String> {

  Optional<UserDto> findByEmail(String email);
}
