package edu.icet.controller;

import edu.icet.dto.Customer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @PostMapping("/add")
    public void addCustomer(Customer customer) {

    }

}
