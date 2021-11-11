package com.spatial.navigation.Navigation.spatial.entity;

import com.spatial.navigation.Navigation.base.BaseEntity;
import com.spatial.navigation.Navigation.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.locationtech.jts.geom.Point;

import javax.persistence.*;

@Entity
@Table(name="customer_location")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class CustomerLocation extends BaseEntity {
    @Column(name = "geom", nullable = false)
    Point geom;

    @OneToOne(targetEntity = Customer.class,optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="customer_id", referencedColumnName = "id", nullable = false)
    Customer customer;
}
