package org.petShop.entities;

import javax.persistence.Column;

public class Cat extends Animal {
    @Column(name="chip_id")
    private String chipId;
}
