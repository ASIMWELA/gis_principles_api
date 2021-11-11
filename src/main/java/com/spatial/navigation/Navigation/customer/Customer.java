package com.spatial.navigation.Navigation.customer;

import com.spatial.navigation.Navigation.base.Person;
import com.spatial.navigation.Navigation.spatial.entity.CustomerLocation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class Customer extends Person {
    @Column(name="location_name", nullable = false)
    String locationName;
    @OneToOne(targetEntity = CustomerLocation.class, mappedBy = "customer")
    CustomerLocation location;
}
