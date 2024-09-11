package com.platzi.pizzeria.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "customer")
@NoArgsConstructor
public class CustomerEntity {
    @Id
    @Column(name = "id_customer", nullable = false, length = 15)
    private String idCustomer;

    @Column(nullable = false, length = 60)
    private String name;

    @Column(nullable = false, length = 60)
    private String address;

    @Column(nullable = false, length = 50, unique = true)
    private  String email;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;
}
