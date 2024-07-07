package com.example.backend.repositories;


import com.example.backend.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationJPARepository extends JpaRepository<Registration, Long>  {}
