package com.workintech.banking.controller;

import com.workintech.banking.entity.Address;
import com.workintech.banking.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/")
    public List<Address> findAll(){
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public Address findById(@PathVariable int id){
        return addressService.find(id);

    }
    @PostMapping("/")
    public Address save(@RequestBody Address address){
        return addressService.save(address);
    }

    @PutMapping("/{id}")
    public Address update(@RequestBody Address address, @PathVariable int id){
        Address findAddress = findById(id);
        if(findAddress != null){
            address.setId(id);
            return addressService.save(address);
        }
            return null;
    }

    @DeleteMapping("/{id}")

    public Address delete(@PathVariable int id){
        Address findAddress = findById(id);
        addressService.delete(findAddress);
        return findAddress;
    }
}
