package com.back.customerservice.service.impl;

import com.back.customerservice.model.Customer;
import com.back.customerservice.repository.CustomerRepository;
import com.back.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    @Override
    public Flux<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Customer> save(Customer customer) {
        if (customer.getName() == null) {
            customer.setName(customer.getName().toUpperCase().trim());
        };
        return repository.save(customer);
    }
}
