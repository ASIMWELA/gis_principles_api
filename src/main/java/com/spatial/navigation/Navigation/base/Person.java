package com.spatial.navigation.Navigation.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Person extends NamedEntity{
    @Column(name="first_name", length = 70, nullable = false)
    String firstName;

    @Column(name="last_name", length = 70, nullable = false)
    String lastName;

}
