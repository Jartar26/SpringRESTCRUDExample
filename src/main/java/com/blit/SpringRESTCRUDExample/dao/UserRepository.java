package com.blit.SpringRESTCRUDExample.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blit.SpringRESTCRUDExample.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
