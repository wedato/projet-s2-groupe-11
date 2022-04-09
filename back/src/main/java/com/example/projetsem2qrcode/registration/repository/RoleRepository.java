package com.example.projetsem2qrcode.registration.repository;

import com.example.projetsem2qrcode.registration.modele.ERole;
import com.example.projetsem2qrcode.registration.modele.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role,String> {
    Optional<Role> findByName(ERole name);
}
