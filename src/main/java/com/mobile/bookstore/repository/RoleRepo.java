package com.mobile.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mobile.bookstore.entity.Role;

public class RoleRepo extends JpaRepository<Role,Integer>{
    Role findByRoleID(int roleID);
}
