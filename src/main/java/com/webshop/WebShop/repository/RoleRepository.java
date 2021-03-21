package com.webshop.WebShop.repository;

import com.webshop.WebShop.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Integer> {

    public Role findByName(String name);
}
