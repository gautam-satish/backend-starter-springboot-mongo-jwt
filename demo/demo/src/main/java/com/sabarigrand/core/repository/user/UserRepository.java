package com.sabarigrand.core.repository.user;

import com.sabarigrand.core.models.entities.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntity, String>, ICustomUserRepository {
}
