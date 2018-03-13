package com.bonade.cloud.repository;

import com.bonade.cloud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
