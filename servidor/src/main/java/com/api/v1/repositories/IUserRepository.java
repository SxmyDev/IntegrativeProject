package com.api.v1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.v1.models.UserModel;

@Repository
public interface IUserRepository extends JpaRepository<UserModel, Long> {
    
}
