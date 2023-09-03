package com.workintech.banking.controller;

import com.workintech.banking.entity.Customer;
import com.workintech.banking.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("/")
    public List<Customer> findAll(){
        return customerService.findAll();
    }
    @GetMapping("/{id}")
    public Customer find(@PathVariable int id){
        return customerService.find(id);
    }
    @PostMapping("/")
    public Customer save(@RequestBody Customer customer){
        return customerService.save(customer);
    }
    @PutMapping("/{id}")
    public Customer update(@RequestBody Customer customer, @PathVariable int id){
        Customer findCustomer = customerService.find(id);
        if(findCustomer != null){
            customer.setId(id);
            return customerService.save(customer);
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public Customer delete(@PathVariable int id){
        Customer findCustomer = customerService.find(id);
       customerService.delete(findCustomer);
       return findCustomer;
    }
}
