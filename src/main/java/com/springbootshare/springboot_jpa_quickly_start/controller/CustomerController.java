package com.springbootshare.springboot_jpa_quickly_start.controller;

import com.springbootshare.springboot_jpa_quickly_start.entity.Customer;
import com.springbootshare.springboot_jpa_quickly_start.repository.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

  @Autowired
  private CustomerRepository customerRepository;

  @PostMapping
  public Customer createCustomer(@RequestBody Customer customer) {
    return customerRepository.save(customer);
  }

  @GetMapping("/{id}")
  public Customer getCustomerById(@PathVariable Long id) {
    return customerRepository.findById(id).orElse(new Customer("DefaultFirstName", "DefaultLastName"));
  }

  @GetMapping("/name/{lastName}")
  public List<Customer> getCustomerByLastName(@PathVariable String lastName) {
    return customerRepository.findByLastName(lastName);
  }

  @PutMapping
  public Customer updateCustomer(@RequestBody Customer customer) {
    return customerRepository.save(customer);
  }
}
