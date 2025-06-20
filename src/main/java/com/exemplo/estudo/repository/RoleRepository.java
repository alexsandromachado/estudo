package com.exemplo.estudo.repository;

import com.exemplo.estudo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
