package com.amruta.happytech.repository;

import com.amruta.happytech.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
