package com.springbootshare.springboot_jpa_quickly_start.repository;

import com.springbootshare.springboot_jpa_quickly_start.entity.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

  List<Customer> findByLastName(String lastName);
}
