package com.sabarigrand.core.repository.user;

import com.sabarigrand.core.models.entities.UserEntity;

public interface ICustomUserRepository {
    UserEntity fetchUserByEmail(String email);
}
