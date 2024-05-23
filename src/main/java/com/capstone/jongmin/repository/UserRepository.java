package com.capstone.jongmin.repository;

import com.capstone.jongmin.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
  Optional<User> findByEmail(String email);
}
