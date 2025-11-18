package com.mysite.sbb.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer>
{
	User findByUserId(String userId);
	
	boolean existsByUserId(String userId);
	
	boolean existsByPhoneNumber(String phoneNumber);
}