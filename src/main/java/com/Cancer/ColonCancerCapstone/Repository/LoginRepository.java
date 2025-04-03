package com.Cancer.ColonCancerCapstone.Repository;

import com.Cancer.ColonCancerCapstone.Model.Login;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoginRepository extends MongoRepository <Login, String> {
}

