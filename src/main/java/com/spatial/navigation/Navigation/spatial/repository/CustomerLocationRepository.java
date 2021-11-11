package com.spatial.navigation.Navigation.spatial.repository;

import com.spatial.navigation.Navigation.spatial.entity.CustomerLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerLocationRepository extends JpaRepository<CustomerLocation, Integer> {
}
