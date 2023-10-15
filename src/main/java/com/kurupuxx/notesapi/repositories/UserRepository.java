package com.kurupuxx.notesapi.repositories;

import org.springframework.data.repository.CrudRepository;

import com.kurupuxx.notesapi.entities.User;

public interface UserRepository extends CrudRepository<User, Long>{
    
}
