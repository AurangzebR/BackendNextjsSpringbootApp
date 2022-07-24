package com.azriasat.nextjsspringapp.repository;

import com.azriasat.nextjsspringapp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
}
