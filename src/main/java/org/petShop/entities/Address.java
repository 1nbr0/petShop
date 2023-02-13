package org.petShop.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="Adresse")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", length = 10)
    private Long id;

    @Column(name="number")
    private String number;

    @Column(name="street")
    private String street;

    @Column(name="zip_code")
    private String zipCode;

    @Column(name="city")
    private String city;
}
