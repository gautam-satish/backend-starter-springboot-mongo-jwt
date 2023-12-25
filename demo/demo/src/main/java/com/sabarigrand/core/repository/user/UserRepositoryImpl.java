package com.sabarigrand.core.repository.user;

import com.sabarigrand.core.models.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserRepositoryImpl implements ICustomUserRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public UserEntity fetchUserByEmail(String email) {
        Criteria criteria = Criteria.where("email").is(email);

        Query query = new Query(criteria);

        UserEntity user =  mongoTemplate.findOne(query, UserEntity.class);

        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }
}
