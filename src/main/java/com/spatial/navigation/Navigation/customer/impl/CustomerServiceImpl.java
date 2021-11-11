package com.spatial.navigation.Navigation.customer.impl;

import com.spatial.navigation.Navigation.commons.ApiResponse;
import com.spatial.navigation.Navigation.customer.Customer;
import com.spatial.navigation.Navigation.customer.CustomerService;
import com.spatial.navigation.Navigation.customer.repository.CustomerRepository;
import com.spatial.navigation.Navigation.spatial.entity.CustomerLocation;
import com.spatial.navigation.Navigation.spatial.repository.CustomerLocationRepository;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerLocationRepository customerLocationRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerLocationRepository customerLocationRepository) {
        this.customerRepository = customerRepository;
        this.customerLocationRepository = customerLocationRepository;
    }


    @Override
    public ResponseEntity<ApiResponse> saveCustomer(Customer customer, double latitude, double longitude) {

        GeometryFactory geometryFactory = new GeometryFactory();
        Point point = geometryFactory.createPoint( new Coordinate( longitude, latitude ) );
        point.setSRID(4326);

        CustomerLocation customerLocation = CustomerLocation.builder()
                .geom(point)
                .build();


        customerRepository.save(customer);
        customerLocation.setCustomer(customer);
        customerLocationRepository.save(customerLocation);


        return ResponseEntity.ok(ApiResponse.builder().success(true).message("Customer saved").build());
    }

    @Override
    public ResponseEntity.HeadersBuilder<?> deleteCustomer(int id) {
        customerRepository.findById(id).ifPresent(customerRepository::delete);
        return ResponseEntity.noContent();
    }
}
