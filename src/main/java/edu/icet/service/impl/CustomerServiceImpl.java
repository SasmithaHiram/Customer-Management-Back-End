package edu.icet.service.impl;

import edu.icet.dto.Customer;
import edu.icet.entity.CustomerEntity;
import edu.icet.repository.CustomerRepository;
import edu.icet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class CustomerServiceImpl implements CustomerService {

    final CustomerRepository repository;
    final ModelMapper mapper;

    @Override
    public void addCustomer(Customer customer) {
        repository.save(mapper.map(customer, CustomerEntity.class));
    }

    @Override
    public void updateCustomer(Customer customer) {
        repository.save(mapper.map(customer, CustomerEntity.class));
    }

    @Override
    public void deleteCustomer(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Customer> getAll() {
        List<CustomerEntity> customerEntityList = repository.findAll();

        ArrayList<Customer> customers = new ArrayList<>();

        customerEntityList.forEach(customerEntity -> {
            customers.add(mapper.map(customerEntity, Customer.class));
        });
        return customers;
    }

    @Override
    public List<Customer> searchCustomerByName(String name) {
        List<CustomerEntity> byName = repository.findByName(name);

        ArrayList<Customer> customers = new ArrayList<>();

        byName.forEach(customerEntity -> {
            customers.add(mapper.map(customerEntity, Customer.class));
        });
        return customers;
    }

    @Override
    public Integer cal(Integer a, Integer b)     {
        return a+b;
    }


    @Override
    public Customer searchCustomer(Integer id) {
        return mapper.map(repository.findById(id), Customer.class);
    }

}
