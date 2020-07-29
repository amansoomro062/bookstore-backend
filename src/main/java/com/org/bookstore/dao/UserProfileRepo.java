package com.org.bookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.bookstore.bean.UserProfile;

public interface UserProfileRepo extends  JpaRepository<UserProfile, String>{

}
