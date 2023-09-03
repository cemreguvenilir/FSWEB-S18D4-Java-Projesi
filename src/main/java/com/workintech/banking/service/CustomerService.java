package com.workintech.banking.service;



import com.workintech.banking.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer find(int id);
    Customer save(Customer customer);
    void delete(Customer customer);
}
