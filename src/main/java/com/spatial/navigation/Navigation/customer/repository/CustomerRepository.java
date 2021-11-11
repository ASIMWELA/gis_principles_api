package com.spatial.navigation.Navigation.customer.repository;

import com.spatial.navigation.Navigation.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
