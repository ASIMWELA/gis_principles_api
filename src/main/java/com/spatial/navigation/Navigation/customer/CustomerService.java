package com.spatial.navigation.Navigation.customer;

import com.spatial.navigation.Navigation.commons.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface CustomerService {
    ResponseEntity<ApiResponse> saveCustomer(Customer customer, double latitude, double longitude);
    ResponseEntity.HeadersBuilder<?> deleteCustomer(int id);
}
