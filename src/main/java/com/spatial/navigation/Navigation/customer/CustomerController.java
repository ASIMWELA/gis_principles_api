package com.spatial.navigation.Navigation.customer;

import com.spatial.navigation.Navigation.commons.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
@Validated
public class CustomerController {
    private final CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(value = "/{latitude}/{longitude}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> saveCustomer(@RequestBody @Valid Customer customer, @PathVariable("latitude") double latitude, @PathVariable("longitude") double longitude){
        return customerService.saveCustomer(customer, latitude, longitude);
    }
}
