package com.weglobal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weglobal.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
