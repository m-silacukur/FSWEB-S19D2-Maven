package com.workintech.s18d4.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    private int no;

    private String city;

    private String country;

    @Column(nullable = true)
    private String description;

    @OneToOne(mappedBy = "address")
    private Customer customer;
}