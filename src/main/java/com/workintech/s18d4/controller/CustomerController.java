package com.workintech.s18d4.controller;

import com.workintech.s18d4.dto.CustomerResponse;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerResponse> findAll() {
        return customerService.findAll().stream()
                .map(c -> new CustomerResponse(c.getId(), c.getEmail(), c.getSalary()))
                .toList();
    }

    @GetMapping("/{id}")
    public CustomerResponse find(@PathVariable Long id) {
        Customer c = customerService.find(id);
        return new CustomerResponse(c.getId(), c.getEmail(), c.getSalary());
    }

    @PostMapping
    public CustomerResponse save(@RequestBody Customer customer) {
        Customer c = customerService.save(customer);
        return new CustomerResponse(c.getId(), c.getEmail(), c.getSalary());
    }

    @PutMapping("/{id}")
    public CustomerResponse update(@PathVariable Long id, @RequestBody Customer customer) {
        customer.setId(id);
        Customer c = customerService.save(customer);
        return new CustomerResponse(c.getId(), c.getEmail(), c.getSalary());
    }

    @DeleteMapping("/{id}")
    public CustomerResponse delete(@PathVariable Long id) {
        Customer c = customerService.delete(id);
        return new CustomerResponse(c.getId(), c.getEmail(), c.getSalary());
    }
}