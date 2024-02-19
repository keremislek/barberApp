package com.example.barbersApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.barbersApp.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
