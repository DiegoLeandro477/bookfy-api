package com.ferruje.bookfy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ferruje.bookfy.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByLoginId(Long loginId);

}
