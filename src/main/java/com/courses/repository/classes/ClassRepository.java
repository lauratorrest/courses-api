package com.courses.repository.classes;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClassRepository extends MongoRepository<ClassDto, String> {

}
